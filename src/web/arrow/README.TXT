Add arrow.jar to project libs
2、Add listeners in ant build.xml or testng.xml

build.xml add listeners sample
<target name="testng" depends="compile">
    <mkdir dir="test-output" />
    <testng outputDir="test-output" classpathref="runpath"
        haltonfailure="fasle" listeners="com.netease.qa.testng.PowerEmailableReporter,
        com.netease.qa.testng.RetryListener, com.netease.qa.testng.TestResultListener">
        <xmlfileset dir="." includes="${testngxml}.xml" />
    </testng>
</target>
testng.xml add listeners sample
<listeners>
    <listener class-name="com.netease.qa.testng.TestResultListener" />
    <listener class-name="com.netease.qa.testng.RetryListener" />
    <listener class-name="com.netease.qa.testng.PowerEmailableReporter" />
</listeners>
3、Add config.properties file in the root directory of your project

config.properties file sample
retrycount=1 #Not must be specified, default value is  0
sourcecodedir=src #Not must be specified, default value is src
sourcecodeencoding=UTF-8 #Not must be specified, default value is utf-8