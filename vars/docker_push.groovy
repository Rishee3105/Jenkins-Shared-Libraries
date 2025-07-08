def call(String ImageName,String ImageTag,String dockerHubUser){
  echo "This is pushing the image to Docker Hub"
  withCredentials([usernamePassword('credentialsId':"dockerHubCred",
  passwordVariable:"dockerHubPass",
  usernameVariable:"dockerHubUser")]){
  sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  sh "docker image tag ${ImageName}:${ImageTag} ${dockerHubUser}/${ImageName}:${ImageTag}"
  sh "docker push ${dockerHubUser}/${ImageName}:${ImageTag}"
}
