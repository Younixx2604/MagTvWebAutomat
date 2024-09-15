Feature: "FILM" - Navigationselement
    @TestCaseKey=KAN-T46
    Scenario: "FILM" - Navigationselement
        
        Given die Homepage "https://web.magentatv.de/" ist geöffnet
        And man Coockies schliesst
        When man klickt "FILM - Navigationselement" an
        Then "https://web.magentatv.de/film" wird geöffnet