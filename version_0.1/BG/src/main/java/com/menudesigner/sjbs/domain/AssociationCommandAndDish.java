package com.menudesigner.sjbs.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JIN Benli on 03/11/14.
 */
@Entity
@Table(name = "jb_command_dish")
public class AssociationCommandAndDish implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Id
    @Column(name = "DISHID")
    private Integer dish_id;

    @Id
    @Column(name = "COMMANDID")
    private Integer command_id;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne(optional = false, targetEntity = Dish.class)
    @PrimaryKeyJoinColumn(name = "DISHID", referencedColumnName = "ID")
    private Dish dish;

    @ManyToOne(optional = false, targetEntity = Command.class)
    @PrimaryKeyJoinColumn(name = "COMMANDID", referencedColumnName = "ID")
    private Command command;

    protected AssociationCommandAndDish() {
    }

    public Integer getDish_id() {
        return dish_id;
    }

    public void setDish_id(Integer dish_id) {
        this.dish_id = dish_id;
    }

    public Integer getCommand_id() {
        return command_id;
    }

    public void setCommand_id(Integer command_id) {
        this.command_id = command_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "AssociationCommandAndDish{" +
                "id=" + id +
                ", dish_id=" + dish_id +
                ", command_id=" + command_id +
                ", quantity=" + quantity +
                ", dish=" + dish +
                ", command=" + command +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssociationCommandAndDish)) return false;

        AssociationCommandAndDish that = (AssociationCommandAndDish) o;

        if (command != null ? !command.equals(that.command) : that.command != null) return false;
        if (command_id != null ? !command_id.equals(that.command_id) : that.command_id != null) return false;
        if (dish != null ? !dish.equals(that.dish) : that.dish != null) return false;
        if (dish_id != null ? !dish_id.equals(that.dish_id) : that.dish_id != null) return false;
        if (!id.equals(that.id)) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (dish_id != null ? dish_id.hashCode() : 0);
        result = 31 * result + (command_id != null ? command_id.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (dish != null ? dish.hashCode() : 0);
        result = 31 * result + (command != null ? command.hashCode() : 0);
        return result;
    }
}
