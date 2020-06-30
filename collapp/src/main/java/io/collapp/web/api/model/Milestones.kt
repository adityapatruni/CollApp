
package io.collapp.web.api.model

import io.collapp.model.ColumnDefinition

class Milestones
@java.beans.ConstructorProperties("milestones", "statusColors") constructor(
        val milestones: List<MilestoneInfo>, val statusColors: Map<ColumnDefinition, Int>)
