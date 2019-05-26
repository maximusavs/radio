package ru.com.radio.adapters

import ru.com.radio.R
import ru.com.radio.databinding.CardStationListBinding
import ru.com.radio.models.RecyclerModel
import ru.com.radio.models.StationModel

class StationsListAdapter : CategoryAdapter<RecyclerModel, CardStationListBinding>(
    R.layout.card_station_list
) {
    var onLikeClick: (StationModel, Boolean) -> Unit = {_,_ ->}
    override fun onBindViewHolder(holder: CategoryHolder<CardStationListBinding>, position: Int) =
        with(holder.binding) {
            holder.itemView.setOnClickListener { onItemClick(position) }
            checkLike.setOnClickListener { onLikeClick(getItem(position).station, checkLike.isChecked) }
            model = getItem(position)
            executePendingBindings()
        }
}