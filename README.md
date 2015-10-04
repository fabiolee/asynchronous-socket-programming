# Asynchronous Socket Programming in Java
I have this question long time ago, how to transfer data from one client to another through a server? After some Google search, I think the keyword that I am looking for should be "Asynchronous Socket Programming".

I manage to find the keyword, but I fail to find a simple example in Java. So, I decide to write one myself based on <a href="http://www.prasannatech.net/2008/07/socket-programming-tutorial.html" target="_blank">Socket Programming tutorial by S.Prasanna</a>.
<div align="center"><img src="http://farm4.static.flickr.com/3283/2920705535_7f6624ce37.jpg" border="0" /></div>
First of all, I am going to create two projects, TCPServer & TCPClient.
<ol>
<li>TCPServer having three threads for captures input (Main.java), read clients output (ReadThread.java) & read client new connection (ConnectThread.java).</li>
<li>TCPClient having two threads for captures input (Main.java) & read server output (ReadThread.java).</li>
</ol>

Here are some demo scenes:
<div align="center"><img src="http://farm4.static.flickr.com/3064/2920705537_3c7f22b83b.jpg" border="0" /></div>
First of all, open the TCPServer program.
<div align="center"><img src="http://farm4.static.flickr.com/3014/2920705539_db9311a78b.jpg" border="0" /></div>
Open two TCPClient program, connect to TCPServer.
<div align="center"><img src="http://farm4.static.flickr.com/3292/2920705541_5718e9e633.jpg" border="0" /></div>
Send message from TCPClient A program to TCPServer.
<div align="center"><img src="http://farm4.static.flickr.com/3036/2920705543_138c91fcee.jpg" border="0" /></div>
Send message from TCPClient B program to TCPServer.
<div align="center"><img src="http://farm4.static.flickr.com/3167/2920705553_de7109a32e.jpg" border="0" /></div>
Send message from TCPServer to both TCPClient programs.
<div align="center"><img src="http://farm4.static.flickr.com/3181/2921557042_1a1ee24380.jpg" border="0" /></div>
Lastly, I try to disconnect one of the TCPClient program.

This is my first socket connection program, correct me if I make any mistake.
