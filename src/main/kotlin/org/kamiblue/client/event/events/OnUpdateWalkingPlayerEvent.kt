package org.kamiblue.client.event.events

import net.minecraft.util.math.Vec3d
import org.kamiblue.client.event.Cancellable
import org.kamiblue.client.event.Event
import org.kamiblue.client.event.IMultiPhase
import org.kamiblue.client.event.Phase
import org.kamiblue.client.util.math.Vec2f
import org.kamiblue.commons.extension.next

class OnUpdateWalkingPlayerEvent private constructor(
    var moving: Boolean,
    var rotating: Boolean,
    var sprinting: Boolean,
    var sneaking: Boolean,
    var onGround: Boolean,
    var pos: Vec3d,
    var rotation: Vec2f,
    override val phase: Phase
) : Event, IMultiPhase<OnUpdateWalkingPlayerEvent>, Cancellable() {

    constructor(moving: Boolean, rotating: Boolean, sprinting: Boolean, sneaking: Boolean, onGround: Boolean, pos: Vec3d, rotation: Vec2f)
        : this(moving, rotating, sprinting, sneaking, onGround, pos, rotation, Phase.PRE)

    override fun nextPhase(): OnUpdateWalkingPlayerEvent {
        return OnUpdateWalkingPlayerEvent(moving, rotating, sprinting, sneaking, onGround, pos, rotation, phase.next())
    }

}