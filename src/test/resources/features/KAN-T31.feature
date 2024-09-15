Feature: Auto_Login_Button_finden
    @TestCaseKey=KAN-T31
    Scenario: Auto_Login_Button_finden

        Given der Benutzer die MagentaTv Homepage "https://web.magentatv.de/" öffnet
        And man schliesst Coockies
        Then sollte ein roter Login Button sichtbar sein
