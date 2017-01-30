# Makefile for the SNMP Package
# Targets are provided for building applications using the package,
# the package as a jar file, and the source distribution.


# Build the SNMP Package into the snmp.jar file
SNMPPackage: 
	mkdir -p build_library
	javac -sourcepath source -d build_library source/snmp/*.java
	jar cvf snmp.jar -C build_library/ .
	rm -rf build_library


# Build the SNMP Inquisitor application as the SNMPInquisitor.jar file
SNMPInquisitor: 
	mkdir -p build_inquisitor
	javac -sourcepath source -d build_inquisitor source/SNMPInquisitor.java
	jar cvfm SNMPInquisitor.jar manifest/SNMPInquisitor.mf -C build_inquisitor/ .
	rm -rf build_inquisitor


# Build the SNMP Agent Test application as the SNMPAgentTest.jar file
SNMPAgentTest: 
	mkdir -p build_agent_test
	javac -sourcepath source -d build_agent_test source/SNMPAgentTest.java
	jar cvfm SNMPAgentTest.jar manifest/SNMPAgentTest.mf -C build_agent_test/ .
	rm -rf build_agent_test


# Build the SNMP Trap Test application as the SNMPTrapTest.jar file
SNMPTrapTest: 
	mkdir -p build_trap_test
	javac -sourcepath source -d build_trap_test source/SNMPTrapTest.java
	jar cvfm SNMPTrapTest.jar manifest/SNMPTrapTest.mf -C build_trap_test/ .
	rm -rf build_trap_test


# Archive the SNMP Package source distribution into the snmp_source.zip file
SNMPDistribution: 
	zip -r snmp_source.zip source manifest build.xml Makefile ReadMe ChangeLog


