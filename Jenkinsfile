//构建版本的名称
def tag = "latest"
//docker地址
def docker_url = "docker.io"
//docker项目名称
def docker_project_name = "jetanex"

node {
    //把选择的项目信息转为数组
    def selectedProjects = "${project_name}".split(',');
    //把选择的服务区信息转为数组
    def selectedServers = "${publish_server}".split(',');

    stage('pull code') {
        checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: '8ef8f501-5664-43bb-bb71-fa2fe0ad2929', url: 'git@github.com:cuijiyao01/mycloud2020.git']]])
    }
    stage('build image') {
        sh "mvn clean install";
        sh "mvn -f cloud-api-commons clean install";

        for(int i=0;i<selectedProjects.size();i++){
          def currentProject = selectedProjects[i];
          def currentProjectName = currentProject.split('@')[0];
          def currentProjectPort = currentProject.split('@')[1];
          //定义镜像名称
          def imageName = "${currentProjectName}:${tag}";
          //编译，构建本地镜像
          sh "mvn -f ${currentProjectName} clean package dockerfile:build";
          //给镜像打标签
          sh "docker tag ${imageName} ${docker_project_name}/${imageName}";

          //登录docker，并上传镜像
          withCredentials([usernamePassword(credentialsId: 'b50aec70-d279-493e-88c1-ebc12247dc0c', passwordVariable: 'password', usernameVariable: 'username')]) {
            //登录
            sh "docker login -u ${username} -p ${password} ${docker_url}"
            //上传镜像
            sh "docker push ${docker_project_name}/${imageName}"
            sh "echo 镜像上传成功!"
          }

          //删除本地镜像
          sh "docker rmi -f ${imageName}"
          sh "docker rmi -f ${docker_project_name}/${imageName}"
          sh "echo 删除本地镜像成功!"
          sh "echo ${currentProjectName}项目完成编译和构建镜像"

          for(int j=0;j<selectedServers.size();j++){
            def currentServer = selectedServers[j];
            echo "${currentServer}开始部署项目"
            sshPublisher(publishers: [sshPublisherDesc(configName: "${currentServer}",
            transfers: [sshTransfer(cleanRemote: false, excludes: '',
            execCommand: "/opt/jenkins_shell/deployCluster.sh ${docker_url} ${docker_project_name} ${currentProjectName} ${tag} ${currentProjectPort}",
            execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false,
            patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '',
            sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])

            echo "${currentProjectName}完成编译，构建镜像"
          }
        }


        
        echo "集群部署完成"

    }
}
