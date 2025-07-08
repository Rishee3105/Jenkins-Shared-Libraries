def call(String ImageName,String ImageTag){
  echo "This is Building the code"
  sh "whoami"
  sh "docker build -t ${ImageName}:${ImageTag} ."
}
