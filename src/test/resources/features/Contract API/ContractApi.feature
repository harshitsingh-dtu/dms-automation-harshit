@PureApi
Feature: Contract API's

  @CRDS_ContractTest
  Scenario: Retrieve user details using an Email
    When The user is fetched from the email "akshita.sharma2@osttra.com" from "CRDS" environment
    Then The response from "email" should have the following key and datatype
      | jsonPath                                                                    | dataType |
      | userDetails.id                                                              | String   |
      | userDetails.firstName                                                       | String   |
      | userDetails.lastName                                                        | String   |
      | userDetails.emailId                                                         | String   |
      | userDetails.userStatus                                                      | String   |
      | userDetails.institutionId                                                   | String   |
      | userDetails.institutionName                                                 | String   |
      | userDetails.institutionAllowedDomains                                       | Array    |
      | userDetails.institutionAllowedDomains[*]                                    | String   |
      | userDetails.countryCode                                                     | Number   |
      | userDetails.phone                                                           | String   |
      | userDetails.isNocUser                                                       | Null     |
      | userDetails.auditDetails                                                    | Object   |
      | userDetails.auditDetails.approvedBy                                         | String   |
      | userDetails.auditDetails.approvedOn                                         | String   |
      | internalCrdsAppDetails                                                      | Object   |
      | internalCrdsAppDetails.crdsStatus                                           | String   |
      | internalCrdsAppDetails.orgTypeRolePGs.roleId                                | Number   |
      | internalCrdsAppDetails.orgTypeRolePGs.roleName                              | String   |
      | internalCrdsAppDetails.orgTypeRolePGs.pgs                                   | Array    |
      | internalCrdsAppDetails.orgTypeRolePGs.pgs[*]                                | Object   |
      | internalCrdsAppDetails.orgTypeRolePGs.pgs[*].id                             | Number   |
      | internalCrdsAppDetails.orgTypeRolePGs.pgs[*].pgName                         | String   |
      | internalCrdsAppDetails.businessMappings                                     | Array    |
      | internalCrdsAppDetails.businessMappings[*]                                  | Object   |
      | internalCrdsAppDetails.businessMappings[*].id                               | Number   |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.assetClass           | String   |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.csGroupId            | Number   |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.appName              | String   |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.commercialServices   | Array    |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.commercialServices[*].acCsId | Array |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.commercialServices[*].csName | Array |
      | mapLegacyUserId                                                             | Null     |
      | mapLegacyUserCrmTicketId                                                    | Null     |
      | legacyUserAppId                                                             | Null     |

  @CRDS_ContractTest
  Scenario: Retrieve user details using an Id
    When The user is fetched from the id "1537aa08-f527-47ef-90c9-0e12d6f7a8c3" from "CRDS" environment
    Then The response from "id" should have the following key and datatype
      | jsonPath                                                                    | dataType |
      | userDetails.id                                                              | String   |
      | userDetails.firstName                                                       | String   |
      | userDetails.lastName                                                        | String   |
      | userDetails.emailId                                                         | String   |
      | userDetails.userStatus                                                      | String   |
      | userDetails.institutionId                                                   | String   |
      | userDetails.institutionName                                                 | String   |
      | userDetails.institutionAllowedDomains                                       | Array    |
      | userDetails.institutionAllowedDomains[*]                                    | String   |
      | userDetails.countryCode                                                     | Number   |
      | userDetails.phone                                                           | String   |
      | userDetails.isNocUser                                                       | Null     |
      | userDetails.auditDetails                                                    | Object   |
      | userDetails.auditDetails.approvedBy                                         | String   |
      | userDetails.auditDetails.approvedOn                                         | String   |
      | internalCrdsAppDetails                                                      | Object   |
      | internalCrdsAppDetails.crdsStatus                                           | String   |
      | internalCrdsAppDetails.orgTypeRolePGs.roleId                                | Number   |
      | internalCrdsAppDetails.orgTypeRolePGs.roleName                              | String   |
      | internalCrdsAppDetails.orgTypeRolePGs.pgs                                   | Array    |
      | internalCrdsAppDetails.orgTypeRolePGs.pgs[*]                                | Object   |
      | internalCrdsAppDetails.orgTypeRolePGs.pgs[*].id                             | Number   |
      | internalCrdsAppDetails.orgTypeRolePGs.pgs[*].pgName                         | String   |
      | internalCrdsAppDetails.businessMappings                                     | Array    |
      | internalCrdsAppDetails.businessMappings[*]                                  | Object   |
      | internalCrdsAppDetails.businessMappings[*].id                               | Number   |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.assetClass           | String   |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.csGroupId            | Number   |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.appName              | String   |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.commercialServices   | Array    |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.commercialServices[*].acCsId | Array |
      | internalCrdsAppDetails.businessMappings[*].acCsDetails.commercialServices[*].csName | Array |
      | mapLegacyUserId                                                             | Null     |
      | mapLegacyUserCrmTicketId                                                    | Null     |
      | legacyUserAppId                                                             | Null     |

  @CRDS_ContractTest
  Scenario: Fetch the user details via Search
    When The user is fetched by searching filter "akshita.sharma2@osttra.com" from "CRDS" environment
    Then The response from "filter" should have the following key and datatype
      | jsonPath                               | dataType |
      | content                                | Array    |
      | content[*].countryCode                 | Number   |
      | content[*].id                          | String   |
      | content[*].firstName                   | String   |
      | content[*].lastName                    | String   |
      | content[*].emailId                     | String   |
      | content[*].userStatus                  | String   |
      | content[*].institutionId               | String   |
      | content[*].institutionName             | String   |
      | content[*].institutionShortName        | String   |
      | content[*].institutionAllowedDomains   | Array    |
      | content[*].institutionStatus           | String   |
      | content[*].phone                       | String   |
      | content[*].userType                    | String   |
      | content[*].crmTicketId                 | String   |
      | content[*].ssoStatus                   | String   |
      | pageNumber                             | Number   |
      | totalPages                             | Number   |
      | totalElements                          | Number   |
      | size                                   | Number   |
      | sortColumns                            | Array    |
      | sortColumns[*]                         | String   |

  @CRDS_ContractTest
  Scenario: Retrieve user details using multiple Ids
    When The user is fetched from ids from "CRDS" environment
      | userId                               |
      | 6d4f72cf-d5b5-4946-85bc-65ce8aaaf005 |
      | dd8e17ee-6076-4284-8a4b-765d41aac5e1 |
      | 22f7aa6d-c42a-49ac-a075-73cf4e620547 |
    Then The response from "multipleId" should have the following key and datatype
      | jsonPath                                | dataType |
      | *.institutionStatus                     | String   |
      | *.institutionShortName                  | String   |
      | *.userType                              | String   |
      | *.institutionName                       | String   |
      | *.crmTicketId                           | String   |
      | *.ssoStatus                             | String   |
      | *.firstName                             | String   |
      | *.lastName                              | String   |
      | *.countryCode                           | Number   |
      | *.phone                                 | String   |
      | *.emailId                               | String   |
      | *.userStatus                            | String   |
      | *.institutionId                         | String   |
      | *.id                                    | String   |

  @Jigsaw_ContractTest
  Scenario: Fetch User Details via jigsaw Api
    When User fetch lei from Customer Reference Data from "JIGSAW" environment