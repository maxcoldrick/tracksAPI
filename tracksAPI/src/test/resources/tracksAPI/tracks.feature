Feature: An example

  @automated
  Scenario: Correct response code and acceptable latency
    Given an authenticated user
    When a GET request is sent to "https://testapi.io/api/ottplatform/media"
    Then the response code is 200
    And the response time is below 1 second

  @automated
  Scenario: Validate ID field
    Given an authenticated user
    When a GET request is sent to "https://testapi.io/api/ottplatform/media"
    Then the ID field is never null for all items
    And the ID field is never empty for all items
    And the segment_type field is "music" for all items

  @automated
  Scenario: Validate primary title list
    Given an authenticated user
    When a GET request is sent to "https://testapi.io/api/ottplatform/media"
    Then the primary title list is never null for all items
    And the primary title list is never empty for all items

  @automated
  Scenario: Now playing only reports true for one track
    Given an authenticated user
    When a GET request is sent to "https://testapi.io/api/ottplatform/media"
    Then only one track reports true for now_playing

  @automated
  Scenario: Validate response header date
    Given an authenticated user
    When a GET request is sent to "https://testapi.io/api/ottplatform/media"
    Then the response header has a valid date

  @manual
  Scenario: Now playing is updated
    Given a track which is not currently playing
    When I play the track
    Then the now_playing field is updated accordingly

  @manual
  Scenario: Verify that primary, secondary and tertiary titles are formatted
    Given a track with more than one artist
    When the title list is returned
    Then primary should contain the artist
    And secondary should contain the song title

  @manual
  Scenario: Correct URIs
    Given a track with external links
    When I use a web browser to navigate to the URI
    Then I am redirected to the track in the relative service