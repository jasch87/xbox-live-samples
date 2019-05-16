package xbl.sample.android;

public class UpdateThread extends Thread
{
    private boolean m_running;
    private int m_targetFPS = 30;
    private double m_averageFPS = 0.0;
    private long m_targetNanoTime = 0;

    private MainActivity m_activity;

    public UpdateThread(MainActivity activity)
    {
        super();
        m_activity = activity;

        setTargetFPS(60);
    }

    @Override
    public void run()
    {
        long startNanoTime = 0;
        long totalNanoTime = 0;
        long deltaNanoTime = 0;
        long waitNanoTime = 0;
        int frameCount = 0;

        while(m_running)
        {
            startNanoTime = System.nanoTime();

            m_activity.Update(deltaNanoTime / 1000000000.0);

            m_targetNanoTime = 1000000000/m_targetFPS + (m_targetNanoTime - deltaNanoTime);

            waitNanoTime = m_targetNanoTime - (System.nanoTime() - startNanoTime);

            if (waitNanoTime > 0)
            {
                try
                {
                    Thread.sleep(waitNanoTime / 1000000);
                }catch(Exception e){}
            }

            deltaNanoTime = System.nanoTime() - startNanoTime;
            totalNanoTime += deltaNanoTime;
            frameCount++;

            if(frameCount == m_targetFPS)
            {
                m_averageFPS = frameCount / (totalNanoTime / 1000000000.0);
                frameCount = 0;
                totalNanoTime = 0;
            }
        }
    }

    public void setRunning(boolean isRunning)
    {
        m_running = isRunning;
    }

    public boolean isRunning()
    {
        return m_running;
    }

    public void setTargetFPS(int frames)
    {
        if (frames > 0)
        {
            m_targetFPS = frames;
        }
    }

    public int getTargetFPS()
    {
        return m_targetFPS;
    }

    public double getAverageFPS()
    {
        return m_averageFPS;
    }
}