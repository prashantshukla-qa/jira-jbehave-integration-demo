package com.qait.automation.jbehavedemo.storyrunners;

import org.junit.Test;

import com.qait.automation.jbehavedemo.utils.report.PublishJiraReport;

public class JiraReportIT {
    @Test
    public void test() {
	PublishJiraReport jirareport = new PublishJiraReport();
	jirareport.pushJiraComment();
    }
}
