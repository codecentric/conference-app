package de.codecentric.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import de.codecentric.domain.Session;
import de.codecentric.domain.SessionType;

public class XlsSessionReader {

    public static int ID_OFFSET = 1000000;
    private static final short COL_DATE = 0;
    private static final short COL_START = 1;
    private static final short COL_END = 2;
    private static final short COL_TOPIC = 3;
    private static final short COL_AUTHOR = 4;
    private static final short COL_AUTHOR2 = 5;
    private static final short COL_DESCRIPTION = 6;
    private static final short COL_LOCATION = 7;
    private static final short COL_TYPE = 8;
    private static final short COL_AUTHORINFO = 9;
    private static final short COL_AUTHOR2INFO = 10;
    private static final short COL_AUTHORIMAGEURL = 11;
    private static final short COL_AUHTOR2IMAGEURL = 12;

    public List<Session> readAllSessions() {
        try {
            final InputStream is = this.getClass().getClassLoader().getResourceAsStream("program.xls");
            return readAllSessions(is);
        } catch (Exception e) {
            throw new RuntimeException("Error while reading sessions from file", e);
        }
    }

    public List<Session> readAllSessions(String filename) {
        try {
            final InputStream is = new BufferedInputStream(new FileInputStream(filename));
            return readAllSessions(is);
        } catch (Exception e) {
            throw new RuntimeException("Error while reading sessions from file " + filename, e);
        }
    }

    private List<Session> readAllSessions(InputStream is) {
        final List<Session> result = new ArrayList<Session>();

        try {
            final POIFSFileSystem fileSystem = new POIFSFileSystem(is);
            final HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
            final HSSFSheet sheet = workBook.getSheet("Alle Tage");

            int rows = sheet.getPhysicalNumberOfRows();
            // as the row is a header we start with the second one
            for (int r = 1; r < rows; r++) {
                final HSSFRow row = sheet.getRow(r);
                if (row == null) {
                    continue;
                }
                final Session session = getSessionFromRow(row, r);
                if (session != null) {
                    result.add(session);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while reading sessions from file", e);
        }
        return result;
    }

    private Session getSessionFromRow(HSSFRow row, int id) {
        Session result = null;
        final String date = getCellValue(row.getCell(COL_DATE, Row.RETURN_BLANK_AS_NULL));
        final String start = getCellValue(row.getCell(COL_START, Row.RETURN_BLANK_AS_NULL));
        final String end = getCellValue(row.getCell(COL_END, Row.RETURN_BLANK_AS_NULL));
        final String title = getCellValue(row.getCell(COL_TOPIC, Row.RETURN_BLANK_AS_NULL));
        final String author = getCellValue(row.getCell(COL_AUTHOR, Row.RETURN_BLANK_AS_NULL));
        final String author2 = getCellValue(row.getCell(COL_AUTHOR2, Row.RETURN_BLANK_AS_NULL));
        final String description = getCellValue(row.getCell(COL_DESCRIPTION, Row.RETURN_BLANK_AS_NULL));
        final String location = getCellValue(row.getCell(COL_LOCATION, Row.RETURN_BLANK_AS_NULL));
        final SessionType type = SessionType.getTypeForString(getCellValue(row.getCell(COL_TYPE, Row.RETURN_BLANK_AS_NULL)));
        final String authorInfo = getCellValue(row.getCell(COL_AUTHORINFO, Row.RETURN_BLANK_AS_NULL));
        final String author2Info = getCellValue(row.getCell(COL_AUTHOR2INFO, Row.RETURN_BLANK_AS_NULL));
        final String authorImgUrl = getCellValue(row.getCell(COL_AUTHORIMAGEURL, Row.RETURN_BLANK_AS_NULL));
        final String author2ImgUrl = getCellValue(row.getCell(COL_AUHTOR2IMAGEURL, Row.RETURN_BLANK_AS_NULL));

        if (title != null || author != null || description != null) {
            result = new Session(date, start, end, title, author, author2, description, location, type, authorInfo, author2Info, authorImgUrl, author2ImgUrl, id + ID_OFFSET);
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date startDate = sdf.parse(date);
            result.setStartDate(startDate);
        } catch (Exception e) {
        }

        return result;
    }

    private String getCellValue(HSSFCell cell) {
        String result = null;
        if (cell != null) {
            switch (cell.getCellType()) {

            case HSSFCell.CELL_TYPE_FORMULA:
                result = cell.getCellFormula().toString();
                break;

            case HSSFCell.CELL_TYPE_NUMERIC:
                result = "" + cell.getNumericCellValue();
                break;

            case HSSFCell.CELL_TYPE_STRING:
                result = cell.getStringCellValue();
                break;

            default:
            }
        }
        return result;
    }

}
