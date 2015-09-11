package com.qait.automation.tests.storyrunners;

import org.junit.Test;

import com.qait.automation.utils.report.PublishJiraReport;

public class JiraReportIT {
    @Test
    public void test() {
	PublishJiraReport jirareport = new PublishJiraReport();
	jirareport.pushJiraComment();
    }
}
