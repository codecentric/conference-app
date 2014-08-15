Narrative:
In order to to avoid invalid e-mail-addresses
As a speaker 
I want to validate e-mail-adresses

Scenario: Correct e-mail-adress

Given user is on the speaker creation page
When user sets the e-mail-address 'max.mustermann@web.de'
And user saves the speaker
Then e-mail is valid

Scenario: Empty e-mail-adress

Given user is on the speaker creation page
When user sets the e-mail-address ''
And user saves the speaker
Then e-mail is valid

Scenario: Incorrect e-mail-adress

Given user is on the speaker creation page
When user sets the e-mail-address 'max.mustermann@host-ohne-domain'
And user saves the speaker
Then user is on the speaker creation page
And e-mail validation error is 'Mail address invalid. Try something like "john.doe@aol.com"'
