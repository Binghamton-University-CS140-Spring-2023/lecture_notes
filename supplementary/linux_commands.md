# Linux Commands

If you are working on a windows machine, I highly recommend downloading git bash, [which you can download from here](https://git-scm.com/downloads). Not only does it allow you to do all the git commands you will need to push and pull your code throughout the semester, it also allows you to run linux commands within the shell that opens up.

This means, all the command listed below are relevant, regardless of what operating system your personal computer may be using.

# Navigating through your file system

Once you download git bash, go ahead and run the executable.
You should see a terminal like window spawn.

It will start you off in some home directory, which is configurable. For now, we won't go into the details on changing the home directory.

To view where you currently are, you can run the `pwd` (print working directory) command:

`pwd`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ pwd
/home/shawn-bailey/teaching/fall-2022/cs140/lecture_notes/supplementary
```

One thing worth noting. In linux (or git bash which basically emulates linux for all intensive purposes of this discussion) `.` is treated as the current directory you reside in. 

`..` is short hand for the previous directory, in other words, one directory up from where you currently are.

We can change which directory we are in by running the `cd` (change directory) command. For example:

`cd ..`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ cd ..
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ pwd
/home/shawn-bailey/teaching/fall-2022/cs140/lecture_notes
```

You can see, I started off in some directory called `supplementary` which was a directory residing the the directory `lecture_notes`. After running the `cd ..` to go back one, we can see that running `pwd` shows we are now one directory above, in the `lecture_notes` directory.

To go back into the `supplementary`, I can do:

`cd supplementary`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ cd ..
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ pwd
/home/shawn-bailey/teaching/fall-2022/cs140/lecture_notes
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ cd supplementary
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ pwd
/home/shawn-bailey/teaching/fall-2022/cs140/lecture_notes/supplementary
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ 
```

Another useful couple tricks, linux treats `~` as shorthand for your home directory. So no matter where we are, we can always go to our home directory by running:

`cd ~`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ cd ~
shawn-bailey@bgmdevel:~$ pwd
/home/shawn-bailey
shawn-bailey@bgmdevel:~$ 
```

When we `cd` into some new directory, we can always go back to the wherever we last were by running:

`cd -`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ cd ~
shawn-bailey@bgmdevel:~$ pwd
/home/shawn-bailey
shawn-bailey@bgmdevel:~$ cd -
/home/shawn-bailey/teaching/fall-2022/cs140/lecture_notes/supplementary
```

The change directory command we have seen can work relatively, from where you are via the `cd ..` command. You could also go more than one directory backwards at a time:

`cd ../..` 

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ cd ../..
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140$ 
```

Here, I went back to lecture_notes one level, and then back another level all at once, to the `cs140` directory.

The change directory command can also work absolutely. For instance, running this from any folder:

`cd /home/shawn-bailey/Desktop`

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ cd /home/shawn-bailey/Desktop/
shawn-bailey@bgmdevel:~/Desktop$
```
After some repetition, navigating your file system via the command line can become second nature. I recommend you just practice moving around your file system.

Couple pitfalls with naming directories:

I recommend naming your directories without spaces. This results in needing to specify spaces to the cd command to account for moving into directories whose name involves spaces.

Instead, name your directories with underscores.

Example: I called my directory `lecture_notes` instead of `"lecture notes"`.

# Viewing stuff in your file system

To view everything that is in your current directory, run the `ls` (list) command, which "lists"
everything in your current directory.

`ls` 

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ ls
alpha.class  bravo.class  gamma.class  linux_commands.md  tmp
alpha.java   bravo.java   gamma.java   test.txt
```

Here, you will see I have some java files, class files, txt files, markdown files, and a directory called `tmp`. Note that the contents of `tmp` were not listed out here.

To list only certain file types, you can pass additional arguments to the `ls` command.
For instance, suppose I wanted to only see `.java` files:

`ls *.java`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ ls *.java
alpha.java  bravo.java  gamma.java
```

Note that `*` here is a wild character. Linux will try to find all files that end with `.java` here, in a regular expression like fashion.

You can also pass directory names to the `ls` command. 
Suppose I ran the following command:

`ls tmp` 

Example Result:
 
``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ ls tmp
10.txt  11.txt  1.txt  2.txt  3.txt  4.txt  5.txt  6.txt  7.txt  8.txt  9.txt
```

We see that it will list out everything within the `tmp` directory.


You can make the `ls` command list out recursively, by doing the following:

`ls -R`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes/supplementary$ ls -R
.:
alpha.class  bravo.class  gamma.class  linux_commands.md  tmp
alpha.java   bravo.java   gamma.java   test.txt

./tmp:
10.txt  11.txt  1.txt  2.txt  3.txt  4.txt  5.txt  6.txt  7.txt  8.txt  9.txt
```

Here, you see it started by listing everyting in the current directory, (recall the `.` is short hand for your current directory). And it is then recursively listing the contents in the `tmp` directory.

# Making new Directories.

Now that you know how to navigate via the `cd` command, and list the context via `ls`, we can discuss making directories and files.

To make a directories where you currently reside, run the `mkdir` (make directory) command:

`mkdir example_dir`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ ls
00_useful_course_software.md  03_arrays_of_primitive_types.md  supplementary
01_primitive_data_types.md    04_strings.md
02_flow_control.md            README.md
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ mkdir example_dir
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ ls
00_useful_course_software.md  03_arrays_of_primitive_types.md  README.md
01_primitive_data_types.md    04_strings.md                    supplementary
02_flow_control.md            example_dir
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ 
```

Here, you can clearly see that before the `mkdir` command, the directory `example_dir` did not exist, but does after running the command.

If I wanted to create multiple directories at once, `mkdir` also allows that:

`mkdir dir1 dir2 dir3`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ ls
00_useful_course_software.md  03_arrays_of_primitive_types.md  README.md
01_primitive_data_types.md    04_strings.md                    supplementary
02_flow_control.md            example_dir
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ mkdir dir1 dir2 dir3
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ ls
00_useful_course_software.md     04_strings.md  example_dir
01_primitive_data_types.md       dir1           README.md
02_flow_control.md               dir2           supplementary
03_arrays_of_primitive_types.md  dir3
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ 
```

I can also create a nested path all at once, by specifying the `-p` (path) flag:

`mkdir -p this/folder/is/mighty/nested`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ ls
00_useful_course_software.md     04_strings.md  example_dir
01_primitive_data_types.md       dir1           README.md
02_flow_control.md               dir2           supplementary
03_arrays_of_primitive_types.md  dir3
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ mkdir -p this/folder/is/mighty/nested
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ ls -R
.:
00_useful_course_software.md     04_strings.md  example_dir
01_primitive_data_types.md       dir1           README.md
02_flow_control.md               dir2           supplementary
03_arrays_of_primitive_types.md  dir3           this

./dir1:

./dir2:

./dir3:

./example_dir:

./supplementary:
alpha.class  bravo.class  gamma.class  linux_commands.md  tmp
alpha.java   bravo.java   gamma.java   test.txt

./supplementary/tmp:
10.txt  11.txt  1.txt  2.txt  3.txt  4.txt  5.txt  6.txt  7.txt  8.txt  9.txt

./this:
folder

./this/folder:
is

./this/folder/is:
mighty

./this/folder/is/mighty:
nested

./this/folder/is/mighty/nested:
```

# File creation

You can create an empty file where you currently reside, by running the `touch` command:

`touch new_file.txt`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ ls
00_useful_course_software.md     04_strings.md  example_dir
01_primitive_data_types.md       dir1           README.md
02_flow_control.md               dir2           supplementary
03_arrays_of_primitive_types.md  dir3           this
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ touch new_file.txt
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ ls
00_useful_course_software.md     04_strings.md  example_dir    this
01_primitive_data_types.md       dir1           new_file.txt
02_flow_control.md               dir2           README.md
03_arrays_of_primitive_types.md  dir3           supplementary
```

You could also create a file by opening and saving one via text editor, say gedit for example:

`gedit gedit_file.txt`

This will open gedit, and a file called `gedit_file.txt`. If the file already exists, then gedit will just open the existing file for you to edit.

There are other command line text editors, such as `vi` or `emacs`. I won't discuss those details here, but you can feel free to google them. (I personally am a `vim` guy).

# Deletion

You can delete a file by running the `rm` (remove) command. For example:

`rm new_file.txt`

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ ls
00_useful_course_software.md     04_strings.md  example_dir    this
01_primitive_data_types.md       dir1           new_file.txt
02_flow_control.md               dir2           README.md
03_arrays_of_primitive_types.md  dir3           supplementary
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ rm new_file.txt
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ ls
00_useful_course_software.md     04_strings.md  example_dir
01_primitive_data_types.md       dir1           README.md
02_flow_control.md               dir2           supplementary
03_arrays_of_primitive_types.md  dir3           this
```

You can delete a directory by running the `rm` command with the `-rf` (recursive, force) flags:

Example Result:

``` bash
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ ls
00_useful_course_software.md     04_strings.md  example_dir
01_primitive_data_types.md       dir1           README.md
02_flow_control.md               dir2           supplementary
03_arrays_of_primitive_types.md  dir3           this
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ rm -rf dir1 dir2 dir3
00_useful_course_software.md     04_strings.md  this
01_primitive_data_types.md       example_dir
02_flow_control.md               README.md 
03_arrays_of_primitive_types.md  supplementary
```

If you try to run the `rm` command without the `-f` (force) flag you get an error. (This is for safety purposes):

`rm supplementary`

Example Result:

```
shawn-bailey@bgmdevel:~/teaching/fall-2022/cs140/lecture_notes$ rm supplementary/
rm: cannot remove 'supplementary/': Is a directory
```

# Summary

| Symbol | Description |
| --- | ----------- |
| `.` | Current directory |
| `..` | One directory back |
| `~` | Home directory |
| `*` | Wild card character |

| Command | Description |
| --- | ----------- |
| `pwd` | Prints working directory. |
| `cd ..` | Changes one directory backwards |
| `cd ~` | Changes to home directory |
| `cd -` | Change to previous directory |
| `cd dir` | Change to directory `dir` (assuming `dir` exists where you currently are) |
| `cd ../..` | Change two directories backwards |
| `ls` | Lists everything in your current directory |
| `ls *.java` | Lists all `.java` files in your current directory. |
| `ls dir` | Lists contents of directory `dir` (assuming `dir` exists where you currently are) |
| `ls -R` | Lists all contents in a directory, recursively. |
| `mkdir new_dir` | Makes a new directory in current directory, called `new_dir`. |
| `mkdir -p path` | Makes a new directory at the specified path. Create path if it doesn't exist. |
| `touch filename` | Create an empty file, called `filename`. |
| `gedit filename` | Opens `filename` in gedit. If the file doesn't exist, creates it as well. |
| `rm filename` | Removes the file called `filename`. |
| `rm -rf dir` | Forcible removes the directory called `dir`. |

# Conclusion

This was created since a student brought up they were struggling with the terminal.

I hope this is somewhat helpful to you all as you are getting your feet wet with navigating coding via the commannd line.

Let me know if there is anything else you would like me to cover related to linux commands in general. I think this covers a good starting point to at least get comfortable.

By the way, you can run the `man` manual command to get more details about certain ways to use these tools.

Example for the `ls` command:

`man ls`

``` bash
LS(1)                           User Commands                           LS(1)

NAME
       ls - list directory contents

SYNOPSIS
       ls [OPTION]... [FILE]...

DESCRIPTION
       List  information  about the FILEs (the current directory by default).
       Sort entries alphabetically if none of -cftuvSUX nor --sort is  speci‐
       fied.

       Mandatory  arguments  to  long options are mandatory for short options
       too.

       -a, --all
              do not ignore entries starting with .

       -A, --almost-all
              do not list implied . and ..

 Manual page ls(1) line 1 (press h for help or q to quit)
```

You can quit out of the manual page opened by pressing `q`. Which will bring you back to the command line.

You can scroll downward by holding the `ENTER` key.

There are other savvy ways to search for things in opened manual pages, but that's beyond the scope of this discussion. The point is, you can google things, but also the `man` command can get you details about these command straight in your command line.


