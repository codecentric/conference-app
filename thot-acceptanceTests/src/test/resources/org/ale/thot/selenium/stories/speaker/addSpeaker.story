Narrative:
In order to publish the speaker profile for the conference atendees
As a speaker 
I want to add my speaker profile


Scenario: Create speaker

Given user is on the speaker creation page
When user sets forename 'David'
And user sets last name 'Völkel'
And user sets the bio 'David's bio'
And user sets the e-mail-address 'david@voelkel.de'
And user saves the speaker
Then a speaker exists with forename 'David', last name 'Völkel' and bio 'David's Bio'


Scenario: Update speaker

Given user is on speakers site
And user selects speaker with forename 'David' and with last name 'Völkel'
When user sets forename 'David korrigiert'
And user sets last name 'Völkel korrigiert'
And user sets the bio 'David's bio korrigiert'
And user sets the e-mail-address 'david.korrigiert@voelkel.de'
And user saves the speaker
Then a speaker with forename 'David' and with last name 'Völkel' does not exist
And a speaker exists with forename 'David korrigiert', last name 'Völkel korrigiert' and bio 'David's Bio korrigiert'
