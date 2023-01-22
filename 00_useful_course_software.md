<!--https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet
https://stackoverflow.com/questions/35465557/how-to-apply-color-in-markdown-->


-----------------------------
**CS 140 Programming with Objects and Data Structures**

-----------------------------

**Introduction**

**Main Course Resources**

## BrightSpace

- Use BrightSpace for the syllabus and other course details.

## Installing Java

- TO DO: Download and install a Java 17 JDK
 - You can use Amazon Corretto:
 <a href="https://aws.amazon.com/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc" target="blank">Click the Download for Amazon Corretto 17</a>.
 Since it is free and supported by Amazon, some of our labs will have have this one.
 - Alternatives for Java 17 (openJDK) Development Kit (Java SDK) include: <a href="https://jdk.java.net/17/" target="blank">openJDK</a>
 - Another source is <a href="https://www.azul.com/products/core/" target="blank">Azul Java</a>
 - You could choose the commercial version from Oracle: it is free when you use it for
 personal use: <a href="https://www.oracle.com/technetwork/java/javase/downloads/index.html" target="blank">Oracle Java</a>
- IMPORTANT: On Windows (if you do not use Corretto, which kindly does it for you) you need to get the path to the java `bin` directory into your path. I don't know if Azul modifies the system Path.
 For all version on Mac and Linux it is either automatic or needs a different procedure.
 - For Windows with openJDK, Oracle and possibly Azul, right click on `This PC` and select `Properties`, then on the right side of the System Window, click
on `Advanced Systems Settings`.
 - In the `System Properties` dialog, click on `Environment Variables...` near the bottom.
 - Click on `Path` in the *LOWER* window (System variables) and click the `Edit` button near the bottom.
 - If you chose Amazon Corretto, you should find that the Path was modified during the install:
 `C:\Program Files\Amazon Corretto\jdk17.0.2_8\bin` (or maybe a later version number). If it is there just use Cancel to exit this whole process.
 - If you chose the OpenJDK, you need to click the `New` button and paste in the path to `javac`, probably
 `C:\Program Files\jdk-17\bin`--but you need to check in the file explorer. Then click `OK` on each window and close the System window.
 - If you chose the Oracle, you need to click the `New` button and paste in the path to `javac`, probably
 `C:\Program Files\Java\jdk-17.0.1\bin`--but you need to check in the file explorer.. Then click `OK` on each window and close the System window.
 - Any problems, bring your computer to Lab or come to office hours.
 
## Git Bash
 
- TODO for Windows: Download and install Git Bash from this <a href="https://git-scm.com/downloads" target="blank">download page</a>.
Use the defaults (on Mac and Linux Git should already be installed).
Typing Git Bash in the search field of Windows will open a Git terminal window, where you can
clone the same repository you use in Lab. You can repeat the instructions from Lab.

## Atom

- TODO for Windows: Download and install Atom for Windows from the <a href="https://atom.io/" target="blank">Atom download page</a>. We will be using Gedit in the labs.

## Github

- TODO If you do not have a GitHub account, go to <a href="https://github.com/" target="blank">Github</a> and sign up.
Once you have signed up for an account, fill out and submit this <a href="https://forms.gle/nmQLykMJvxpaqDix9" target="blank">Google Form</a> so we can get identify you in GitHub classroom.

