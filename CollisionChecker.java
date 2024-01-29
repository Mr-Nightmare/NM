package Main;

import entity.entity;

public class CollisionChecker{
    GamePanels gp;


    CollisionChecker(GamePanels gp){
        this.gp = gp;
    }

    public void checkTile(entity Entity){
        
        int entityLeftWorldX = Entity.worldX + Entity.solidArea.x;
        int entityRightWorldX = Entity.worldX + Entity.solidArea.x + Entity.solidArea.width;
        int entityTopWorldY = Entity.worldY + Entity.solidArea.y;
        int entityBottomtWorldY = Entity.worldY + Entity.solidArea.y + Entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomtWorldY/gp.tileSize;

        int tileNum1 , tileNum2;


        switch(Entity.Direction){
        
        case "up" :
        entityTopRow = (entityTopWorldY - Entity.speed)/gp.tileSize;

        tileNum1 = gp.TM.mapTileNUM[entityLeftCol][entityTopRow];
        tileNum2 = gp.TM.mapTileNUM[entityRightCol][entityTopRow];

        if(gp.TM.tile[tileNum1].collision==true||gp.TM.tile[tileNum2].collision==true){
        Entity.collisionOn=true;
        }
        break;


        case "down" :
        entityBottomRow = (entityBottomtWorldY - Entity.speed)/gp.tileSize;

        tileNum1 = gp.TM.mapTileNUM[entityLeftCol][entityBottomRow];
        tileNum2 = gp.TM.mapTileNUM[entityRightCol][entityBottomRow];

        if(gp.TM.tile[tileNum1].collision==true||gp.TM.tile[tileNum2].collision==true){
        Entity.collisionOn=true;
        }
        break;
        
        
        case "left" :
        entityLeftCol = (entityLeftWorldX - Entity.speed)/gp.tileSize;

        tileNum1 = gp.TM.mapTileNUM[entityLeftCol][entityTopRow];
        tileNum2 = gp.TM.mapTileNUM[entityLeftCol][entityBottomRow];

        if(gp.TM.tile[tileNum1].collision==true||gp.TM.tile[tileNum2].collision==true){
        Entity.collisionOn=true;}
        break;


        case "right" :
        entityRightCol = (entityRightWorldX - Entity.speed)/gp.tileSize;

        tileNum1 = gp.TM.mapTileNUM[entityRightCol][entityTopRow];
        tileNum2 = gp.TM.mapTileNUM[entityRightCol][entityBottomRow];

        if(gp.TM.tile[tileNum1].collision==true||gp.TM.tile[tileNum2].collision==true){
        Entity.collisionOn=true;    
        break;  

        }

    }
}
}
