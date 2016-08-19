/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.jbehavedemo.storyrunners;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.qait.automation.TestSessionInitiator;
import com.qait.automation.jbehavedemo.getstory.Constants;
import com.qait.automation.jbehavedemo.getstory.JiraSprintStoryFinder;
import com.qait.automation.utils.FileHandler;
import com.qait.automation.jbehavedemo.getstory.JiraStoryDownloader;
import com.qait.automation.jbehavedemo.stepdefs.PageStepDef;
import com.qait.automation.jbehavedemo.stepdefs.StartTestStepDef;

import static com.qait.automation.utils.ConfigPropertyReader.getProperty;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters;

/**
 *
 * @author prashantshukla
 */
public class StoryTest extends JUnitStories {

	// private final String rapidViewId = "2";

	private final CrossReference xref = new CrossReference();

	public StoryTest() {

		FileHandler.cleanStoryLocation();
		if (System.getProperty("storyId") != null) {
			new JiraStoryDownloader(System.getProperty("storyId")).storeJiraStoryLocally();
		} else {

			JiraSprintStoryFinder sprintStories = new JiraSprintStoryFinder(getProperty("rapidViewId"));

			sprintStories.getJiraSprintStories().stream().map((sprintStory) -> {
				return sprintStory;
			}).map((sprintStory) -> new JiraStoryDownloader(sprintStory)).forEach((jirastory) -> {
				jirastory.storeJiraStoryLocally();
			});
		}
		configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
				.doIgnoreFailureInView(true).useThreads(1).useStoryTimeoutInSecs(180);
	}

	@Override
	public Configuration configuration() {
		// return new MostUsefulConfiguration();

		Class<? extends Embeddable> embeddableClass = this.getClass();
		Properties viewResources = new Properties();
		viewResources.put("decorateNonHtml", "true");
		ParameterConverters parameterConverters = new ParameterConverters();
		ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(),
				new LoadFromClasspath(embeddableClass), parameterConverters);
		// add custom converters
		parameterConverters.addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd")),
				new ParameterConverters.ExamplesTableConverter(examplesTableFactory));

		URL storyURL = null;
		try {
			storyURL = new URL("file://" + System.getProperty("user.dir") + "/" + Constants.STORY_LOC);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return new MostUsefulConfiguration()
				.useStoryControls(new StoryControls().doDryRun(false).doSkipScenariosAfterFailure(false))
				.useStoryLoader(
						new LoadFromRelativeFile(storyURL))
				.useStoryParser(
						new RegexStoryParser(
								examplesTableFactory))
				.useStoryPathResolver(new UnderscoredCamelCaseResolver())
				.useStoryReporterBuilder(new StoryReporterBuilder()
						.withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass)).withDefaultFormats()
						.withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
						.withViewResources(viewResources).withFormats(Format.ANSI_CONSOLE, Format.XML)
						.withFailureTrace(true).withFailureTraceCompression(true).withCrossReference(xref))
				.useParameterConverters(parameterConverters).useStepMonitor(xref.getStepMonitor());
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new StartTestStepDef());
	}

	@Override
	protected List<String> storyPaths() {
		URL codeLocation = CodeLocations.codeLocationFromPath(Constants.STORY_LOC);
		List<String> paths = new StoryFinder().findPaths(codeLocation, Arrays.asList("/*.story"), Arrays.asList(""));
		return paths;
	}
}
