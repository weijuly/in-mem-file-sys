Feature: In Memory File System

  Scenario: Check initial properties of file system
    When filesystem is created
    Then pwd should return directory "/"
    Then ls should return 0 items

  Scenario: Create a file and list it
    When filesystem is created
    When touch "f01"
    Then ls should return 1 items
    Then item 0 of ls should have name "f01"
    Then item 0 of ls should be of type "FILE"

  Scenario: Create a directory and list it
    When filesystem is created
    When mkdir "d01"
    Then ls should return 1 items
    Then item 0 of ls should have name "d01"
    Then item 0 of ls should be of type "DIRECTORY"

  Scenario: Create a directory, enter into and exit from the directory
    When filesystem is created
    When mkdir "d01"
    When cd to "d01"
    Then pwd should return directory "/d01/"
    Then ls should return 0 items
    When cd to ".."
    Then pwd should return directory "/"
    
  Scenario: Change to an non existent directory
    When filesystem is created
    When cd to "d01"
    Then pwd should return directory "/"
