package jackal.face;

public class Perk {
    private String name;
    private String description;
    private int cost;
    private int level;
    private int maxLevel;
    private boolean purchased;
    private boolean active;
    public Perk(String name, String description, int cost, int maxLevel) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.maxLevel = maxLevel;
        this.level = 0;
        this.purchased = false;
        this.active = false;
    }
    public void purchase() {
        if (this.purchased) {
            throw new IllegalStateException("Perk already purchased");
        }
        this.purchased = true;
    }
    public void activate() {
        if (!this.purchased) {
            throw new IllegalStateException("Perk not purchased");
        }
        this.active = true;
    }
    public void deactivate() {
        this.active = false;
    }
    public void upgrade() {
        if (!this.purchased) {
            throw new IllegalStateException("Perk not purchased");
        }
        if (this.level >= this.maxLevel) {
            throw new IllegalStateException("Perk already at max level");
        }
        this.level++;
    }
    public String getDescription() {
        return this.description;
    }
    public int getCost() {
        return this.cost;
    }
    public int getLevel() {
        return this.level;
    }
    public int getMaxLevel() {
        return this.maxLevel;
    }
    public boolean isPurchased() {
        return this.purchased;
    }
    public boolean isActive() {
        return this.active;
    }

    public String getName() {
        return this.name;
    }

    }