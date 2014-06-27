package com.example.TileGenie;

import flash.display.Sprite;
import flash.events.Event;
import flash.Lib;

/**
 * Created by Edwin on 27/06/2014.
 */
public class DaPlanner extends Sprite{
    private var map:Array<Int>;

    map = new Array<Int>();

    public static var TILE_WIDTH = 60;
    public static var TILE_HEIGHT = 60;
    public static var SCREEN_WIDTH = 600;
    public static var SCREEN_HEIGHT = 360;

    var w = Std.int(SCREEN_WIDTH / TILE_WIDTH);
    var h = Std.int(SCREEN_HEIGHT / TILE_HEIGHT);

    public function new() {
        super();

        for (i in 0...map.length) {
            var tile = new Tile(map[i]);
            var x = i % w;
            var y = Math.floor(i / w);
            tile.setLoc(x, y);
            addChild(tile);
        }
    }

    public static function main() {
        Lib.current.addChild(new Main());
    }

    public function new(id:Int) {
        super();

        switch(id) {
            case 1:
                image = new Bitmap(Assets.getBitmapData("assets/grassLeftBlock.png"));
            case 2:
                image = new Bitmap(Assets.getBitmapData("assets/grassCenterBlock.png"));
            case 3:
                image = new Bitmap(Assets.getBitmapData("assets/grassRightBlock.png"));
            case 4:
                image = new Bitmap(Assets.getBitmapData("assets/goldBlock.png"));
            case 5:
                image = new Bitmap(Assets.getBitmapData("assets/globe.png"));
            case 6:
                image = new Bitmap(Assets.getBitmapData("assets/mushroom.png"));
        }
        addChild(image);
    }

    for (i in 0...w * h) {
        map[i] = 1
    }

    public function setLoc(x:Int, y:Int) {
        if (image != null) {
            image.x = x * Main.TILE_WIDTH;
            image.y = y * Main.TILE_HEIGHT;
        }
    }
}

