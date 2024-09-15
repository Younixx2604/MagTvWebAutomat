Feature: Auto_Login_Button_anklicken_&_Login_Seite_öffnen
    @TestCaseKey=KAN-T32

    Scenario: Auto_Login_Button_anklicken_&_Login_Seite_öffnen

        Given die MagentaTV Homepage  "https://web.magentatv.de/" ist geöffnet
        And man den Coockies Banner schliesst
        When der Benutzer den roten Login Button anklickt
        Then sollte der URL der Login-Seite  "https://accounts.login.idm.telekom.com/oauth2" enthalten