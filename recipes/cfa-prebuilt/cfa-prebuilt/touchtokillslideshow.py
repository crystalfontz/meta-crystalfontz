import os,io,pprint,string,subprocess

evt_file = open("/dev/input/touchscreen0", "rb")

cmdstring="fuser /home/root/images/slideshow.sh"
pid=os.popen(cmdstring).read()
evt = evt_file.read(16) # Read the event
pidstring="pid = "+pid
print pidstring
killstring="kill "+pid
os.system(killstring)
os.system("fbv /home/root/images/blank.jpg")
os.system("/etc/init.d/xserver-nodm restart")
