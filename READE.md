PS C:\Users\Coll147\Documents\TareaGit> echo "# Cool repo" >> README.md
PS C:\Users\Coll147\Documents\TareaGit> git init
Initialized empty Git repository in C:/Users/Coll147/Documents/TareaGit/.git/
PS C:\Users\Coll147\Documents\TareaGit> git add README.md
PS C:\Users\Coll147\Documents\TareaGit> git commit -m "init repo"
[master (root-commit) ed92922] init repo
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 README.md
PS C:\Users\Coll147\Documents\TareaGit> git branch -M main
PS C:\Users\Coll147\Documents\TareaGit> git remote add origin https://github.com/acollca-design/fuzzy-happiness.git
PS C:\Users\Coll147\Documents\TareaGit> git push -u origin main

remote: Permission to acollca-design/fuzzy-happiness.git denied to Coll147.
fatal: unable to access 'https://github.com/acollca-design/fuzzy-happiness.git/': The requested URL returned error: 403
PS C:\Users\Coll147\Documents\TareaGit> git switch -c frontend
Switched to a new branch 'frontend'
PS C:\Users\Coll147\Documents\TareaGit> git switch main
Switched to branch 'main'
PS C:\Users\Coll147\Documents\TareaGit> git switch -c backend
Switched to a new branch 'backend'
PS C:\Users\Coll147\Documents\TareaGit> git push -u origin main
Enumerating objects: 3, done.
Counting objects: 100% (3/3), done.
Writing objects: 100% (3/3), 246 bytes | 246.00 KiB/s, done.
Total 3 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
To https://github.com/acollca-design/fuzzy-happiness.git
 * [new branch]      main -> main
branch 'main' set up to track 'origin/main'.
PS C:\Users\Coll147\Documents\TareaGit> switch main
En línea: 1 Carácter: 7
+ switch main
+       ~
Una instrucción switch debe tener uno de los siguientes elementos: 
'-file NombreArchivo' o '( expresión )'.
En línea: 1 Carácter: 7
+ switch main
+       ~
Falta el carácter '{' en la instrucción switch .
    + CategoryInfo          : ParserError: (:) [], ParentContainsE 
   rrorRecordException
    + FullyQualifiedErrorId : PipelineValueRequired
 
PS C:\Users\Coll147\Documents\TareaGit> git switch main
Switched to branch 'main'
Your branch is up to date with 'origin/main'.
PS C:\Users\Coll147\Documents\TareaGit> git add README.md
PS C:\Users\Coll147\Documents\TareaGit> git commit -m 'Fix README.md formatting (UTF-8)'
[main 4b7dec1] Fix README.md formatting (UTF-8)
 1 file changed, 0 insertions(+), 0 deletions(-)
PS C:\Users\Coll147\Documents\TareaGit> git push -u origin main
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Writing objects: 100% (3/3), 293 bytes | 293.00 KiB/s, done.
Total 3 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
To https://github.com/acollca-design/fuzzy-happiness.git
   ed92922..4b7dec1  main -> main
branch 'main' set up to track 'origin/main'.
PS C:\Users\Coll147\Documents\TareaGit> git switch frontend
Switched to branch 'frontend'
PS C:\Users\Coll147\Documents\TareaGit> git merge main^C
PS C:\Users\Coll147\Documents\TareaGit> git switch frontend
Already on 'frontend'
PS C:\Users\Coll147\Documents\TareaGit> git merge main
Updating ed92922..4b7dec1
Fast-forward
 README.md | Bin 28 -> 12 bytes
 1 file changed, 0 insertions(+), 0 deletions(-)
PS C:\Users\Coll147\Documents\TareaGit> git push -u origin frontend
Total 0 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
remote: 
remote: Create a pull request for 'frontend' on GitHub by visiting:
remote:      https://github.com/acollca-design/fuzzy-happiness/pull/new/frontend
remote: 
To https://github.com/acollca-design/fuzzy-happiness.git
 * [new branch]      frontend -> frontend
branch 'frontend' set up to track 'origin/frontend'.
PS C:\Users\Coll147\Documents\TareaGit> git switch backend
Switched to branch 'backend'
PS C:\Users\Coll147\Documents\TareaGit> git merge main
Updating ed92922..4b7dec1
Fast-forward
 README.md | Bin 28 -> 12 bytes
 1 file changed, 0 insertions(+), 0 deletions(-)
PS C:\Users\Coll147\Documents\TareaGit> git push -u origin backend
Total 0 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)
remote: 
remote: Create a pull request for 'backend' on GitHub by visiting:
remote:      https://github.com/acollca-design/fuzzy-happiness/pull/new/backend
remote: 
To https://github.com/acollca-design/fuzzy-happiness.git
 * [new branch]      backend -> backend
branch 'backend' set up to track 'origin/backend'.
PS C:\Users\Coll147\Documents\TareaGit> git branch
* backend
  frontend
  main
PS C:\Users\Coll147\Documents\TareaGit> git add .
PS C:\Users\Coll147\Documents\TareaGit> git reset READE.md
PS C:\Users\Coll147\Documents\TareaGit> git commit -m 'add example java code'
[backend ead74b2] add example java code
 7 files changed, 118 insertions(+)
 create mode 100644 pom.xml
 create mode 100644 src/main/java/com/ejemplo/MiWebApplication.java
 create mode 100644 src/main/java/com/ejemplo/Task.java
 create mode 100644 src/main/java/com/ejemplo/TaskController.java
 create mode 100644 target/classes/com/ejemplo/MiWebApplication.class
 create mode 100644 target/classes/com/ejemplo/Task.class
 create mode 100644 target/classes/com/ejemplo/TaskController.class
PS C:\Users\Coll147\Documents\TareaGit> git switch frontend
Switched to branch 'frontend'
Your branch is up to date with 'origin/frontend'.
PS C:\Users\Coll147\Documents\TareaGit> git add .
PS C:\Users\Coll147\Documents\TareaGit> git reset READE.md
PS C:\Users\Coll147\Documents\TareaGit> git commit -m 'add example html code'
[frontend f11f0fb] add example html code
 3 files changed, 179 insertions(+)
 create mode 100644 src/main/resources/static/app.js
 create mode 100644 src/main/resources/static/index.html
 create mode 100644 src/main/resources/static/styles.css
PS C:\Users\Coll147\Documents\TareaGit> git switch main
Switched to branch 'main'
Your branch is up to date with 'origin/main'.
PS C:\Users\Coll147\Documents\TareaGit> git merge frontend
Updating 4b7dec1..f11f0fb
Fast-forward
 src/main/resources/static/app.js     | 64 ++++++++++++++++++++++++
 src/main/resources/static/index.html | 21 ++++++++
 src/main/resources/static/styles.css | 94 ++++++++++++++++++++++++++++++++++++
 3 files changed, 179 insertions(+)
 create mode 100644 src/main/resources/static/app.js
 create mode 100644 src/main/resources/static/index.html
 create mode 100644 src/main/resources/static/styles.css
PS C:\Users\Coll147\Documents\TareaGit> git merge backend 
Merge made by the 'ort' strategy.
 pom.xml                                           |  35 ++++++++++++++++
 src/main/java/com/ejemplo/MiWebApplication.java   |  11 +++++
 src/main/java/com/ejemplo/Task.java               |  24 +++++++++++
 src/main/java/com/ejemplo/TaskController.java     |  48 ++++++++++++++++++++++
 target/classes/com/ejemplo/MiWebApplication.class | Bin 0 -> 726 bytes
 target/classes/com/ejemplo/Task.class             | Bin 0 -> 1172 bytes
 target/classes/com/ejemplo/TaskController.class   | Bin 0 -> 3417 bytes
 7 files changed, 118 insertions(+)
 create mode 100644 pom.xml
 create mode 100644 src/main/java/com/ejemplo/MiWebApplication.java
 create mode 100644 src/main/java/com/ejemplo/Task.java
 create mode 100644 src/main/java/com/ejemplo/TaskController.java
 create mode 100644 target/classes/com/ejemplo/MiWebApplication.class
 create mode 100644 target/classes/com/ejemplo/Task.class
 create mode 100644 target/classes/com/ejemplo/TaskController.class
PS C:\Users\Coll147\Documents\TareaGit> 


PD: Maybe some last git commands are missing, my pc crashed :)