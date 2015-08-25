package w.p.j.daomain.one;

import javax.persistence.*;

public class Job {
    @Id
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_salary")
    private Long jobSalary;

    @Column(name = "job_address")
    private String jobAddress;

    /**
     * @return job_id
     */
    public Integer getJobId() {
        return jobId;
    }

    /**
     * @param jobId
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    /**
     * @return job_name
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return job_salary
     */
    public Long getJobSalary() {
        return jobSalary;
    }

    /**
     * @param jobSalary
     */
    public void setJobSalary(Long jobSalary) {
        this.jobSalary = jobSalary;
    }

    /**
     * @return job_address
     */
    public String getJobAddress() {
        return jobAddress;
    }

    /**
     * @param jobAddress
     */
    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }
}