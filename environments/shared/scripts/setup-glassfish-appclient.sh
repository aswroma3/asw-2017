#!/bin/bash

source "/home/vagrant/shared/scripts/common.sh"

# set up GlassFish Java EE constants 
APPCLIENT_ARCHIVE=appclient-10.11.1.111.jar
EXTRACT_PATH=/opt
APPCLIENT_PATH=/opt/appclient

function installLocalGlassFishJavaEEAppclient {
	echo "=============================="
	echo "installing glassfish appclient"
	echo "=============================="
	FILE=${VAGRANT_DOWNLOADS}/$APPCLIENT_ARCHIVE
	cd ${EXTRACT_PATH}
	jar -xf $FILE 
	chmod a+x ${APPCLIENT_PATH}/glassfish/bin/appclient 
}

function setupEnvVars {
	echo "creating glassfish appclient environment variables"
	echo export APPCLIENT_HOME=${APPCLIENT_PATH} >> /etc/profile.d/javaee-appclient.sh
	echo export PATH=\${PATH}:\${APPCLIENT_HOME}/glassfish/bin >> /etc/profile.d/javaee-appclient.sh
}

function setupGlassFishJavaEEAppclient {
	echo "setting up glassfish appclient"
	# niente da fare 
}

function installGlassFishJavaEEAppclient {
	if downloadExists $APPCLIENT_ARCHIVE; then
		installLocalGlassFishJavaEEAppclient
	else
		echo "missing resource: " ${VAGRANT_DOWNLOADS}/$APPCLIENT_ARCHIVE
	fi
}

echo "setup javaee appclient"
installGlassFishJavaEEAppclient
setupEnvVars
setupGlassFishJavaEEAppclient
