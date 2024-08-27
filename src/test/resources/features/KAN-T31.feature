Feature: Auto_Login_Button_finden
    @TestCaseKey=KAN-T31
    Scenario: Auto_Login_Button_finden
        
        When der Benutzer die MagentaTv Homepage "https://web.magentatv.de/" öffnet
        #And der Benutzer den Cookies Banner schliesst
        Then sollte ein roter Login Button sichtbar sein
        And der Login Button sollte klickbar sein