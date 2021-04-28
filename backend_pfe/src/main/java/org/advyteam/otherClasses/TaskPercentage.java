package org.advyteam.otherClasses;

public class TaskPercentage {
    private Integer notStarted = 0;
    private Integer inProgress = 0;
    private Integer onHold = 0;
    private Integer cancelled = 0;
    private Integer finished = 0;

    public TaskPercentage() {
    }


    public Integer getNotStarted() {
        return this.notStarted;
    }

    public void setNotStarted(Integer notStarted) {
        this.notStarted = notStarted;
    }

    public Integer getInProgress() {
        return this.inProgress;
    }

    public void setInProgress(Integer inProgress) {
        this.inProgress = inProgress;
    }

    public Integer getOnHold() {
        return this.onHold;
    }

    public void setOnHold(Integer onHold) {
        this.onHold = onHold;
    }

    public Integer getCancelled() {
        return this.cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }

    public Integer getFinished() {
        return this.finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }
   
    
}
