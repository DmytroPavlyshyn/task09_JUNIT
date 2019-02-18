package com.pavlyshyn;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.*;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit Test suite")
@SelectPackages("com.pavlyshyn")
@IncludeClassNamePatterns({"^.*$"})
public class TestSuit {
}
