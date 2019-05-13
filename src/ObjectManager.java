import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Snowboard snbo;
	
	ObjectManager(Snowboard snbo){
		this.snbo=snbo;
	}
	
	long enemyTimer = 0;
	
	int enemySpawnTime = 1000;
	
	ArrayList<Trees> tree = new ArrayList<Trees>();
	
	void addTrees(Trees tre) {
		tree.add(tre);
	}
	
	void update() {
	snbo.update();	
	
	for(int i = 0; i<tree.size();i++) {
		tree.get(i).update();
	}
	
	}
	
	void draw(Graphics g) {
		snbo.draw(g);
	
	
	for(int i = 0; i<tree.size();i++) {
		tree.get(i).draw(g);
	}
}
	

public void manageEnemies(){
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
                addTrees(new Trees(new Random().nextInt(SnowFall.width), 0, 50, 50));

                enemyTimer = System.currentTimeMillis();
        }
}
	
	void purgeObjects() {
		for(int i = 0; i<tree.size();i++) {
			if(tree.get(i).isAlive==false) {
				tree.remove(i);
			}
		}
	}

	void checkCollision() {
		for(Trees a:tree) {
			if(snbo.collisionBox.intersects(a.collisionBox)) {
				snbo.isAlive=false;
		}
		}
	}
	
}
