Feature: "KIDS" - Navigationselement
    @TestCaseKey=KAN-T49
    Scenario: "KIDS" - Navigationselement
        
        Given "https://web.magentatv.de/" ist geöffnet
        And Coockies schliesst
        When man "KIDS - Navigationselement" clickt
        Then "https://web.magentatv.de/kinder" Seite wird geöffnet