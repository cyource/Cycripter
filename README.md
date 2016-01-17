####LICENSE: GPL 2.0

![alt tag](https://lh3.googleusercontent.com/UNvCxkCFlcYAXU5SE-bgdZeGE_TipLVOyAsCtc9rAguHymLZDcLB_kRZmVna93mfEbo4hZOUMX1b3T1yYek09jB0jxe0chWp-MYg6mlhhU7C0Hsg_80NKwWC1fe9mQ90clpT82Lhvkn5w5-cvS7mEVSfzgNzVlNmKpA9sfyPChIDZ9Wuo5HN4ScEI0FSZ7nOp4_IGdK-lsv8cN3MIRZb1yJAS030AuejOmmnykrqEZIGkjfRJejKtHXaGq_9tXPh_HqKyP-XXYpEHOLMW-gMutDlxttKOQh91j6BQWIIwKpIlCvcbiPwuTytOQExBFeGbbcBlAPMjHx4_cb32KiAHKD8Y9CNFeQepv2z_gpDkHDaBxOh8Wg03k6qdKIfOqNzAAJDBv-GptYblR5GewwijdMOtl5Ru8_OP2Ic17UlR7a_JJYHa5TQPhjA_MoRJy8LNCwETmznvS91s5pwPpCP_lHNE4EfmlmitTzU-d1yLoZT1I4gz7iKYZUN4Qu4U687ii5mucOWBLqwLWZ_9RMtyVfw1WPDZ0oNZW6HD-pfzNquny_2pWiL05XNqTDVzxNI_q_J=w362-h643-no)

###Introduction to Cycripter
A mini-mobile Scripting tool for Android, Cycripter runs some simple commands to make things easier for you. Enter and go! It carries out the function coded, giving a command-line-ish experience combined with a mini-scripter.

###Core for Android
Cycripter is powered by a built-in, little programming language called Core, developed by me. Here is some example Core code to get you started:
<br>
<br>• android.print(&quot;TEXT&quot;)
<br>• android.print(NO. x/+-& NO.)
<br>• android.action([callNumb]-NO.)
<br>• android.action([textMssg]-&quot;MSSG&quot;-NO.)
<br>• android.action([sendMail]-&quot;TITLE&quot;-&quot;MAIL&quot;-&quot;TO&quot;)
<br>
<br>This code can be found in the App's RemoteExpandedStyle of the Quick Settings Menu for CyanogenMod

###CyanogenMod 12.1+ Exclusive
Exclusively for CyanogenMod 12.1+, using the Cyanogen Platform SDK, I added a custom quick tile with expanded menu within Quick Menu for Cycripter, integrating it in some capacity to the framework. Code for this called at the onCreate method at MainActivity.java, but it checks if the device runs CyanogenMod and the right version of the Custom ROM for the Quick Tile feature to work, so it won't affect the app experience for users/developers not running CyanogenMod 12.1+.

###Current Development Focus
• Code Efficency/Simplification (as of 29/11/15)

###Requirements + Dev. Status
|                 | Stock Android       | CyanogenMod|
| -------------   |:-------------:| -----:    |
| Minimum Version    | 4.0 (ICS)     | 9.1       |
| Min. V. for Quick Settings Tile/Menu | N/A           |   12.1    |
| Development Status   | Complete     |    Complete     |

###Credits
• Thanks to <a href="http://www.github.com/futuresimple">Base Labs</a> and <a href="http://www.github.com/chalup">chalup</a> for their Floating Action Menu+Labels for FABs library.
