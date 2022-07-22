package com.goranssonappdev.tile

import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.util.Log

class MyTileService : TileService() {

    private val tag = "WiFiTag"

    override fun onClick() {
        super.onClick()
        Log.d(tag, "onClick")
        if (qsTile.state == Tile.STATE_INACTIVE) {
            qsTile.state = Tile.STATE_ACTIVE
            qsTile.label = "Active"
            qsTile.icon = Icon.createWithResource(this, R.drawable.ic_tile_dnd_on)
            Log.d(tag, "onClick Active")
        } else {
            // Turn off
            qsTile.state = Tile.STATE_INACTIVE
            qsTile.label = "Inactive"
            qsTile.icon = Icon.createWithResource(this, R.drawable.ic_tile_dnd_off)
            Log.d(tag, "onClick Inactive")
        }


        // Update looks
        qsTile.updateTile()
    }

    override fun onTileRemoved() {
        super.onTileRemoved()
        Log.d(tag, "onTileRemoved")
        // Do something when the user removes the Tile
    }

    override fun onTileAdded() {
        super.onTileAdded()
        qsTile.state = Tile.STATE_INACTIVE
        qsTile.label = "Inactive"
        qsTile.icon = Icon.createWithResource(this, R.drawable.ic_tile_dnd_off)
        Log.d(tag, "onTileAdded")
        qsTile.updateTile()
    }

    override fun onStartListening() {
        super.onStartListening()
        Log.d(tag, "onStartListening")
        // Called when the Tile becomes visible
    }

    override fun onStopListening() {
        super.onStopListening()
        Log.d(tag, "onStopListening")
        // Called when the tile is no longer visible
    }

}

