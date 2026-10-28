This Automation Framework consists DNM & ODC scripts and will help you to run your scripts on different environments.
Below are the minimum requirements to make this framework up & running:

1) IDE should be installed along with the dependencies.
2) After successfull installation, maven lifecycle  and configurations will be available.
3) Update the tag in "UserManagementRunner.java" under "tags":
    E.g.  tags = "@addyouTagHere"
4) To Run TestCases, run the following lifecycle configurations of maven in the order mentioned:
    a) clean
    b) test
    c) verify

For Sanity:
    1)Update the tag in "UserManagementRunner.java" under "tags":
          tags = "@Sanity"
    2) Update the cookies.json file under src/test/java/resources with latest

    3) To Run TestCases, run the following lifecycle configurations of maven in the order mentioned:
           a) clean
           b) test
           c) verify
    4) Click on the index.html report link to see results.

Note:
1) For a new Environment, run the scripts with Tag @Global_OTs, @Global_MRs followed by respective feature files because the OTs & MRs are creating data for other scripts.

2) In Order to run on specific environment add the following in the vm arguments of the configuration:
    E.g. -Denvironment=qa

