Simple test jobs to verify JMS message durability

Prerequsites:
- 2 Jenkins instances
- RH CI Plugin installed and optionally the Job DSL plugin.
- Configure the 'Red Hat UMB Stage' message provider in the global config
- Update the receive/receive_job_setup.groovy file to change the UUID to make it unique.

Setup:
- On the receiving Jenkins instance, create a freestyle job with a job dsl step to process receive/receive_job_setup.groovy.
- On the sending Jenkins instance, create a freestyle job with a job dsl step to process send/send_job_setup.groovy.
- Execute both seed jobs above.

Execution:
- Run the send job 3 times.
- Ensure receive job gets triggered 3 times.
- Stop your receiving Jenkins instance.
- Run the send job 3 times again.
- Startup your receiving Jenkins instance.
- Verify that 3 new builds exist for the receive job.


