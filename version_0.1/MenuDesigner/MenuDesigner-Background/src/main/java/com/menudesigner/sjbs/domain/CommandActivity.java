package com.menudesigner.sjbs.domain;

import javax.persistence.*;

/**
 * Created by JIN Benli on 22/12/14.
 */
@Entity
@Table(name = "md_command_activity")
public class CommandActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "command_id", referencedColumnName = "id")
    private Command command;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "activity_id", referencedColumnName = "id")
    private Activity activity;

    public CommandActivity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
