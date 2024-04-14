# White Noise Application Program

This is where I will begin writing about and planning my project in order to formulate and work through my ideas. This will allow me to thoroughly flesh out the modifications I would like to work on.


# List of priorities - updated 4/14/2024
- Improve overall GUI and window functionality
- Look into how to add real-time brown noise generation as well.


# Improve overall GUI
- Decided to use Swing framework for layout(just didn't wanna refactor for JavaFX, bleh)
- I want to go for a toolbar structure in the bottom of the screen



I want the general structure as follows: 


[Play/Stop] [Now Playing] [Volume Slider]


# Notes on the Play/Stop Icon
- I may end up switching this for a Play/Stop Image Icon for a more traditional look


# On the Now Playing:
- If i end up going ahead and doing a full on now playing slider that shows progress through audio file, then i will also want to implement a different view for when the white/brown noise is playing because those sounds are generated in real time, and therefore will not have a need for slider functionality

# On the Volume Slider:
- The volume slide is working mostly fine at this point, however there is an issue where i cant really tell the difference between the volume between the 50%-100% range, and most of the difference in actual loudness is in the bottom 50%

