FROM java:8-jre-alpine

ARG engine
ARG extensions
ARG version

# enabling environmental variables configuration
ENV env_var_enabled=true

# force the REST API port to the default one
ENV server_port=8319

# selecting the ESPER as CEP engine
ENV cep_init_engines=${engine}

# to start the LA (optional)
ENV agent_init_extensions=${extensions}


# mounting configuration and extra dependencies volumes
VOLUME /config
VOLUME /dependencies


# mounting configuration and extra dependencies volumes
ADD https://nexus.linksmart.eu/repository/maven-releases/eu/linksmart/services/events/gpl/distributions/iot.learning.universal.agent/${version}/iot.learning.universal.agent-${version}.jar agent.jar
#ONBUILD ADD distributions/IoTAgent/target/*.jar .


# starting the agent
ENTRYPOINT ["java", "-cp","./*:/dependencies/*", "org.springframework.boot.loader.PropertiesLauncher"]
