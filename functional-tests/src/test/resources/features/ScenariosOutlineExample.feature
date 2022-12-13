Feature: Outlines Example Feature File

  Scenario Outline: Multiple Rows Parallel
    Given a step from '<scenario_outline_row_number>' in 'ScenarioOutlinesExample' feature file
    Examples:
      | scenario_outline_row_number |
      | Scenario Outline – Row 1    |
      | Scenario Outline – Row 2    |
      | Scenario Outline – Row 3    |
      | Scenario Outline – Row 4    |
      | Scenario Outline – Row 5    |

  Scenario Outline: Multiple Rows Parallel with different steps
    Given a step '<scenario_outline_row_number>' on the file 'ScenarioOutlinesExample' is defined
    Then print the variables for the scenario '<scenario_outline_row_number>'
    Examples:
      | scenario_outline_row_number |
      | Scenario Outline – Row 1    |
      | Scenario Outline – Row 2    |
      | Scenario Outline – Row 3    |
      | Scenario Outline – Row 4    |
      | Scenario Outline – Row 5    |