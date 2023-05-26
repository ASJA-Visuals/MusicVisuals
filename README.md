# Hold The Line - Music Visualiser

Music Visualisation for Hold The Line - Toto.

A collection of captivating and immersive environment that
beautifully showcases the integration of 3D elements, color palettes, animations,
and audio for a unique Music Visualizer. Made by a group of amazing students.

## Contributors

| Name | Student Number | Class Group |
| --- | --- | --- |
| Sarah Barron | C21415904 | TU856-2 |
| Adrian Thomas Capacite | C21348423 | TU856-2 |
| Jennifer Kearns | C21383126 | TU856-2 |
| Altahier Saleh | C21415952 | TU856-2 |

## Description of the assignment

Music: Toto - Hold The Line (Official Video) - [https://www.youtube.com/watch?v=htgr3pvBr-I](https://www.youtube.com/watch?v=htgr3pvBr-I)

[![Toto - Hold The Line (Official Video)](https://img.youtube.com/vi/htgr3pvBr-I/hqdefault.jpg)](https://www.youtube.com/watch?v=htgr3pvBr-I)

Video: Hold The Line - Music Visuals - [https://youtu.be/NNKwDdRHHi4](https://youtu.be/NNKwDdRHHi4)

[![Hold The Line - Music Visuals](https://img.youtube.com/vi/NNKwDdRHHi4/hqdefault.jpg)](https://youtu.be/NNKwDdRHHi4)

### Adrian's Visuals

Adrian's visuals present a dynamic and engaging Music Visualizer scene featuring
a horse called Pony Hopps, a rainbow stage, and a starry background of
superellipses.

Pony Hopps is a 3D object imported into the scene, illuminated with purple/red
lights. The horse dynamically moves and hops in sync with the music while the
camera perspective shifts around it. The character was inspired by Maxwell the
Cat, who spins happily to a cheerful song.

The stage is a visually reactive disk composed of rainbow-colored arcs, which
respond to the music by changing their length and color, creating a vibrant and
mesmerizing experience.

The background consists of a grid of superellipses that adapt their size and
color according to the music, enhancing the scene's atmosphere and complementing
Pony Hopps and the stage.

### Global Visuals

Global Visuals contains visuals that are shared between the group members. It
contains a Waveform Frame which displays the audio samples as a waveform line
extending from each corner of the screen towards the center.

### Press Start Visuals

Press Start is presented at first when the program is run. It is a simple
visual that displays the text "Press Start" in the center of the screen. When
the user clicks on it or the space bar, it fades out then the music and visuals
start.

### Sarah's Visuals

Visual 1: A rotating spiral of colour-changing ellipses that get smaller as they get closer to the centre of the screen. The radius of each ellipse expands and contracts based on amplitude.

Visual 2: Looks like a rotating throwing star. Spiral pattern is drawn using lines that emanate from the centre of the screen. The amplitude of the music affects the radius of the spiral.

Visual 3: Two circular waveforms: one is an expanding and contracting circular pattern in the centre of the screen, and the other is a series of lines that move from points on a radius outwards. They respond to the amplitude and frequency of the music. This visual also features waveforms on the edges of the screen.

Visual 4: The visual from the Circles class is composed of 5 circles and a sphere. The radii of the circles change according to the amplitude of the music. The circles all rotate in unison and are encompassed by a sphere that bounces to the music. 

Visual 5: The final visual consists of a standard waveform at the front of the screen with metaballs in the back. The metaballs are moving around the screen and globbing together in a random pattern but they are expanding and contracting with the music.


### Jennifer's Visuals

Jennifer’s visuals features 3D speakers, hexagons, a clock and a 3D cube of stars that all react to the music. The class JenniferVisuals extends VScene and contains classes for the different visuals.

The speakers are 3D models of speakers that change colour and size based on the music.

The size of the hexagons increase and decrease based on the music. There are waveforms in the background going from the corners to the centre.

The clock is created where the radius outer circle is determined using the amplitude of the song and the seconds hand ticks in time to the song. The clock is on a background of colourful circles of random sizes.

The cube of stars is an animated 3D space filled with stars that rotate and change colour based on Perlin noise and the average amplitude of the audio input. There are waveforms in the background going from the corners to the centre.


### Altahier's Visuals

Aj’s visuals presents classes containing different visuals. The program creates a rainbow spiral and an expanding circle that reacts to music. 

The rainbow spiral has a size, spacing and speed that can be adjusted, and is mapped to the amplitude of the music to create a dynamic visual effect. The expanding circle also reacts to the music, with its size being mapped to the amplitude of the music. 

The background of the program is set to black, creating a contrast that allows the rainbow spiral and the expanding circle to stand out. The code also imports various libraries and sets up an audio buffer to process the music.

## Instructions

### Repo Instructions

- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

### Running the Visualiser

1. Follow repo instructions above.
2. If you are using the Java debugger in VSCode, you can run the code from the debugger.

3. If you do not have the debugger set up, you can run the .sh script files

- `./java/compile.sh` will compile your code
- `./java/run.sh` will run the code

## How it works

### The Visual Framework - `ie.tudublin.Visual`

The `ie.tudublin.visual` package is a collection of classes designed to create and manage a Music Visualizer application.

1. `Visual.java`:
This abstract class serves as the main framework for a Music Visualizer. It
extends the PApplet class from the Processing library and encapsulates several
audio and analysis classes, including `Minim`, `AudioInput`, `AudioPlayer`,
`FFT`, `BeatDetect`, and `AudioAnalysis`. The class contains fields like
`bufferSize`, `sampleRate`, lyrics, and various audio objects. The constructor
takes in parameters for the buffer size, sample rate, and lerp amount. The
buffer size must be a power of 2. The class also contains several abstract
methods like `settings()`, `setup()`, and `draw()` to be implemented by
subclasses. Additional methods provided in this class include audio-related
methods like `beginAudio()`, `pausePlay()`, and `seek()` as well as lyric-
related methods like `loadLyrics()` and `getLyrics()`. The class also provides
helper methods for translating the origin to the center of the screen and
converting between time formats.

2. `AudioAnalysis.java`: This class is responsible for managing audio analysis
and implements the AudioListener interface. It processes samples to provide
values such as amplitude, waveform, bands, spectrum, and their lerped
counterparts, such as lerpedAmplitude, lerpedWaveform, etc. It includes handling
FFT (Fast Fourier Transform) and BeatDetect objects and provides methods to
analyze and process audio data, allowing for the generation of visualization
based on the audio input.

3. `EaseFunction.java`: This interface represents an easing function that can be
applied to animations or transitions within the visualizer. It provides lambda
functions for smooth and visually appealing interpolation of values over time.

4. `VAnimation.java`: This class manages animations and transitions within the
visualizer. It provides methods to define and control animations, including
timing and easing functions, allowing for a dynamic visual experience based on
the audio input.

5. `VObject.java`: This abstract class represents a visual object in the
visualizer scene, including position, rotation, scale, and effect. It provides
overridable functions for `render()` and `render(elapsed)` to manage the
object's characteristics. Subclasses can override these methods to create custom
visual objects for the visualizer.

6. `VScene.java`: This class inherits from VObject and manages the overall
visual presentation of the Music Visualizer. It is intended to contain a
student's visuals in a dedicated time space within the visuals. It provides
methods to manage and render scenes, including adding VObjects and handling
transitions between different parts of the visualization.

| Class/Asset | Source |
| --- | --- |
| AudioAnalysis.java | Adrian |
| EaseFunction.java | Adrian |
| VAnimation.java | Adrian |
| Visual.java | Modified by Adrian from Starter Code |
| VObject.java | Adrian |
| VScene.java | Adrian |

### Putting it all together - `HoldTheLine.java`

A class `HoldTheLine.java` is created to extend the `Visual.java` class. This class is responsible for creating the visualizer
by managing each of the visual scenes created by the students.

Finally we have the Main.java which starts the `HoldTheLine.java` PApplet sketch.

| Class/Asset | Source |
| --- | --- |
| HoldTheLine.java | Team |
| Main.java | Starter Code |

### Adrian's Visuals - `AdriansVisuals.java`

Adrian's visuals features a Horse named Pony Hopps on a rainbow stage and a
starry background of superelpises.

`AdriansVisuals.java` is a class that extends `VScene` and provides a custom
visual scene for the Music Visualizer application. The class is part of the
`c21348423` package and includes various visual components like `VObject`,
custom animations, and color palettes.

In this class, different visual components such as `Circle`, `HappyHorse`,
`SquigglyArcs`, and `SuperStars` are created, which extend `VObject` for
customized rendering. It also utilizes the `EaseFunction` and `VAnimation` from
the `ie.tudublin.visual` package to create smooth animations and transitions
within the visualizer.  The `Circle`, `HappyHorse` The constructor of
`AdriansVisual`initializes the visual components and sets the scene animations.
The `render(int elapsed)` method is responsible for rendering the visual
elements in this custom scene based on the elapsed time and audio input.

The `render(int elapsed)` method is responsible for rendering the visual
elements in this custom scene based on the elapsed time and audio input. The
`Circle`, `HappyHorse`, `SquigglyArcs`, and `SuperStars` classes are inner
classes in `AdriansVisuals`, which render unique visuals within the scene. These
classes override the `render()` function in their parent `VObject` class to
create custom visualizations.

| Class/Asset | Source |
| --- | --- |
| AdriansVisuals.java | Adrian |
| Horse.obj | Modified by Adrian from [Horse 3D Model](https://free3d.com/3d-model/horse-39028.html) |

### Global Visuals - `GlobalVisuals.java`

Global Visual features four waveform lines drawn from each corner of the screen
to the center. The line displays the amplitude of each sample in the waveform
array.

The `WaveformFrame` draws four waveform lines that extend from each corner of
the screen to the center. The amplitude of each sample in the array is used to
determine the offset of each line segment. The `WaveformFrame` also contains a
`VAnimation` object that defines the transitions in time that result in the
visual effects.

| Class/Asset | Source |
| --- | --- |
| GlobalVisuals.java | Adrian |

### Press Start Visuals - `PressStart.java`

`PressStart.java` is a class that extends `VSceVune`, offering a custom initial
screen for the Music Visualizer program. This class is part of the `global`
package and employs 3d text, custom spotlights, and interactive functionalities.

In this class, the key elements are a 3D text called "Press Start" and multiple
spotlights that illuminate the text. The `PressStart` constructor initializes
these components by loading the 3D text model and adjusting its
appearance. It also sets up the stage for user interactivity by handling
mouse-over and click events.

The `render()` method, responsible for drawing the scene, sets the background
color and configures the spotlights to add depth to the 3D text. It then checks
if the mouse is hovering over the text area, enlarges the text accordingly, and
starts the visualizer when clicked. The `render()` method also manages visual
transitions when moving from the initial screen to the visualizer scene.

| Class/Asset | Source |
| --- | --- |
| PressStart.java | Adrian |

### Sarah's Visuals - `SarahVisuals.java`

In the `Spiral1` class, an ellipse is drawn with gradually decreasing size while rotating around the centre of the screen. The colour of each ellipse changes according to its position in the buffer. The amplitude of the music affects the size of the ellipse. The ellipses are drawn with their centres at (cx, cy) but are not necessarily centred on the screen. The position of the ellipses changes as the theta angle is incremented and the rotate() and scale() functions are called.

In the `Spiral2 class`, generates a visual representation of a spiral composed of a series of lines. The colour of each line is determined by mapping the position in the audio buffer between 240 and 360. This value is used for the hue, saturation and brightness, creating the vortex-like effect at the centre of the spiral. The angle of each point is calculated using the value of i and a constant value, TWO_PI/3, which represents the angle between each segment of the spiral. The cx and cy variables are updated with the current x and y values, to draw a line from the last point to the current point, creating the effect of a triangle spinning. The radius of the spiral is incremented for each point using the value of the amplitude of the audio input, which causes the shape to expand and contract with the music.

In the `SoundWaves class`, the outer circular waveform is plotted point by point. The position in the audio. The angle at which each point should be plotted is obtained by mapping the position in the audio buffer onto TWO_PI, and the radius of the circle at each point is also based on the position in the audio buffer. The inner waveform is created by drawing lines around a circumference. The starting points of each line are plotted on the circle and the endpoints of each line expand and contract with the frequency at each position in the audio buffer.

In the `Circles class`, 5 circles are drawn. Their radii are based on frequency bands. They all rotate together. The sphere rotates on the x, y, and z axes, and the radius of the sphere is tied to the lerped Amplitude.

In the `metaballs` classThe screen is populated with 20 blobs using an array of Blob objects. `Blob` is a nested class in `metaballs`. Every four pixels are coloured to allow the processor to handle the graphics. The colour of the pixel is determined by a modulo calculation of the sum of the radii of the Blob objects divided by the distance from the pixel to each Blob object. The use of the modulo operator creates the recursive blob effect. The amplitude is used to modulate the size of the metaballs. The update() method keeps each Blob moving on the screen and prevents them from moving off the screen.


| Class/Asset | Source |
| --- | --- |
| SarahVisuals.java | Sarah |

### Jennifer's Visuals - `JenniferVisuals.java`

'JenniferVisuals' is a Java class file that contains a program for generating audiovisual effects. It imports various classes from the processing, ddf.minim, and global packages, as well as custom classes such as AudioAnalysis, Clock, Dots, Hex, Speaker, Stars, VObject, and VScene.

The main method in this class is the 'render' method, which takes an integer value representing the amount of time elapsed and generates audiovisual effects accordingly. The 'render' method first checks the elapsed time and then the 'render' methods of several other classes (Speaker, Clock, Dots, Stars, WaveForm, Hex, and GlobalVisual) based on the current elapsed time in the song. This method is called once per frame, so it is constantly updating the visual display based on the progress of the song.

The 'Stars,' 'Dots,' 'WaveForm', 'Hex' and 'Clock' classes are all custom classes that extend the VObject class and implement their own 'render' methods to generate specific audiovisual effects. The 'Clock' class also takes an additional argument, 'elapsed,' to keep track of the time elapsed.

The JenniferVisuals class also contains some additional fields and variables for managing the audio that is being played, such as the 'minim', 'ab', and 'aa' variables. These are used to access and analyse the audio data in real-time so that the visual effects can be synchronised with the audio.

| Class/Asset | Source |
| --- | --- |
| JenniferVisuals.java | Jennifer |
| estrellica.obj | From [Star 3D Model](https://free3d.com/3d-model/star-mobile-ready-60-tris-49986.html) |

### Altahier's Visuals - `AJVisual.java`

The AjVisual program is a class that extends the VScene class, which is a class that is used to create visual scenes in the Processing programming environment. Within the AjVisual class, there is a constructor that initializes various variables, such as the audio buffer, which is used to process the music.

The program creates two different visuals that react to the music. The first visual is a rainbow spiral, which is drawn using the beginShape() method. The spiral has a size, spacing and speed that can be adjusted to create different visual effects. The amplitude of the music is mapped to the size of the spiral, which means that the size of the spiral changes dynamically based on the loudness of the music.

The second visual is an expanding circle, which is drawn using the ellipse() method. The size of the circle is also mapped to the amplitude of the music, which means that the size of the circle changes dynamically based on the loudness of the music.

The program also sets the background of the scene to black using the background() method, which creates a contrast that allows the rainbow spiral and the expanding circle to stand out.

In addition to creating the visuals, the program also imports various libraries and sets up an audio buffer to process the music. The audio buffer is used to analyze the music and extract information such as the amplitude and frequency of the sound.

| Class/Asset | Source |
| --- | --- |
| AJVisual.java | Altahier |

## What I am most proud of in the assignment

### Sarah Barron
I am most proud of my use of mathematics to create spiralling effects in my visuals. I watched a number of videos about the maths behind spirals and I applied it, removing and adding values to get a better understanding of how it works. I’m also very proud of the metaballs visual. It was a learning process, and I hope to apply the knowledge I gained from doing this visual in future projects.

### Adrian Thomas Capacite

I am most proud of the Visual PApplet framework that I have created for this
assignment. As well as that the demos that demonstrate the use of the framework.

I set up the PApplet framework `ie.tudublin.visual` to make the process of
creating the visuals and scenes easier.  I also set up two demos to demonstrate
the use of the framework such as one for demoing the AudioAnalysis and the other
for demoing the VAnimation and VObject classes.

I also created Pony Hopps The Happy Horse along with the other visuals in the
scene. The other visuals are the Squiggly Arcs and the Super Stars.

I am most proud of the PApplet framework that I have created for the team to use.
It allowed us to collaborate and easily create the visuals for the music
visualizer.  This resulted in a visual that was able to flow and transition
between the different scenes.

What I have learned from this assignment are the different methods of creating
generative art with maths and code. An example of this is the Super Starts which
are created with superelipses.

### Jennifer Kearns

I am most proud of the 3D rotating cube of stars that I made for this assignment. I got to learn how to create 3D visuals and how to move and rotate them. I also learned how to load objects from another file and how to create, scale and colour them, and how to move and rotate them in reaction to the music. I was very happy with how it turned out in the end.

### Altahier Saleh

i am most proud of the by the rainbow spiral in the AjVisual code. Working on the spiral visual in the AjVisual code helped me gain a deeper understanding of how to map audio amplitude to visual parameters and create complex, music-reactive graphics in Processing. i could have done better but for the most part i was happy with the way it turned out.
