# ===PONG V1.0===
This is my first game made with Java applet. To run the game, run Pong.java.
--------------------
GAME RULE:
Control the user paddle (left paddle) with Up and Down key to hit the ball to the AI opponent and keep the ball off your wall. 
--------------------
CONSTRUCTION PROCESS:
1. Class Pong is to paint the background frame and catch Key Event for Human Paddle.
2. Class HumanPaddle is to paint the color and location of player paddle. Calculate the movement of player paddle.
3. Class Ball is to paint the color and location of the ball. Randomize a starting direction for the ball. Check the ball collision with borders and paddles.
4. Class AiPaddle is to paint the color and location of AI paddle. The center of AI paddle will track the ball's center.  
5. Test and fix bugs along the way.
