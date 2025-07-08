def call(String ImageName,String ImageTag,String dockerhubUser){
  echo "This is pushing the image to Docker Hub"
  withCredentials([usernamePassword('credentialsId':"dockerHubCred",
  passwordVariable:"dockerHubPass",
  usernameVariable:"dockerHubUser")]){
  sh "docker login -u ${dockerhubUser} -p ${dockerHubPass}"
  sh "docker image tag ${ImageName}:${ImageTag} ${dockerhubUser}/${ImageName}:${ImageTag}"
  sh "docker push ${dockerhubUser}/${ImageName}:${ImageTag}"
}
