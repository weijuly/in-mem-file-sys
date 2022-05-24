Feature: In Memory File System

  Scenario: Creation of file system
    When filesystem is created
    Then pwd should return directory "/"
    Then ls should return 0 items

  Scenario: Creation of file in root directory
    When filesystem is created
    And "FILE" is created with name "f01"
    Then ls should return 1 items
    Then item 0 of ls should have name "f01"
    Then item 0 of ls should be of type "FILE"

  Scenario: Creation of directory in root directory
    When filesystem is created
    And "DIRECTORY" is created with name "d01"
    Then ls should return 1 items
    Then item 0 of ls should have name "d01"
    Then item 0 of ls should be of type "DIRECTORY"
