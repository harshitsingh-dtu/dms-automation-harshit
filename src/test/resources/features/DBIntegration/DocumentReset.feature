#@DataReset @Regression
#Feature: Document Data Reset - Delete documents from DB for test cleanup
#
#  # ============================================================
#  # HOW IT WORKS:
#  #   1. Uses JOIN with lei_org_type table to find exact document
#  #   2. Matches on lei_id + org_type_id + sequence
#  #   3. If NOT found → logs "skipping" and passes the step
#  #   4. If found → deletes all related data from all tables
#  #   5. Works for ALL statuses (Draft, Approved, Enforced, etc.)
#  #
#  # APPROACH:
#  #   DN/DF → JOIN + HAVING (unique match — 1 row)
#  #   4WAY  → EXISTS subquery (avoids cross-mapping issues)
#  #           + ORDER BY created_date DESC LIMIT 1 (latest doc)
#  # ============================================================
#
#
#  # ============================================================
#  # DN Document Reset
#  # Participants: PB + EB + Client (3 total)
#  # orgTypeKey auto-resolved: PB=1, EB=2, Client=3
#  # ============================================================
#  @Reset-DN
#  Scenario: Reset DN document
#    Given User resets DN document
#      | docTypeId   | 2bf00cd5-9056-41a1-a44d-5eb7a555010d |
#      | pbLeiId     | 5299009IW4MUXDSW3Q73                 |
#      | ebLeiId     | 6SHGI4ZSSLCXXQSBB395                 |
#      | clientLeiId | 529900AJLXERVU6GEY09                 |
#
#
#  # ============================================================
#  # DF Document Reset
#  # Participants: PB + EB (2 total)
#  # orgTypeKey auto-resolved: PB=1, EB=2
#  # NOTE: Also auto-deletes all linked child DN documents
#  # ============================================================
#  @Reset-DF
#  Scenario: Reset DF document
#    Given User resets DF document
#      | docTypeId | 7e8116e9-0bb6-4317-bc1b-f980b97bd794 |
#      | pbLeiId   | 54930029D1EIIUNIT125                 |
#      | ebLeiId   | 5299009ZDDB470XLWI78                 |
#
#
#  # ============================================================
#  # 4Way Document Reset
#  # Participants: PB1 + PB2 + Client1 + Client2 (4 total)
#  #
#  # IMPORTANT — pass orgTypeKey for each participant:
#  #   Same lei can appear as both PB (orgType=1) and Client (orgType=3)
#  #   orgTypeKey tells which role this lei plays
#  #
#  # NOTE: Deletes LATEST created document with matching participants
#  # ============================================================
#  @Reset-4Way
#  Scenario: Reset 4Way document
#    Given User resets 4Way document
#      | docTypeId         | 4dcb345e-4611-4a3c-931f-b5325c3df722 |
#      | pb1LeiId          | 254900SLCV8KI86BHL86                 |
#      | pb1OrgTypeKey     | 1                                    |
#      | pb2LeiId          | 6SHGI4ZSSLCXXQSBB395                 |
#      | pb2OrgTypeKey     | 1                                    |
#      | client1LeiId      | 6SHGI4ZSSLCXXQSBB395                 |
#      | client1OrgTypeKey | 3                                    |
#      | client2LeiId      | 254900SLCV8KI86BHL86                 |
#      | client2OrgTypeKey | 3                                    |
