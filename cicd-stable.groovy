node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/terraformport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/terraformport.git'), string(name: 'PORT_DESCRIPTION', value: 'Terraform is an open-source infrastructure as code tool that enables you to safely and predictably provision and manage infrastructure in any cloud' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
