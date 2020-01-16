package com.example.challenges

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

@Suppress("NAME_SHADOWING")
class ChallengesAdapter(private val context: Context, private val challengeModelArrayList: ArrayList<ChallengeModel>) :
    BaseAdapter() {


    override fun getCount(): Int {
        return challengeModelArrayList.size
    }

    override fun getItem(position: Int): Any {
        return challengeModelArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder

        if (convertView == null) {
            holder = ViewHolder()
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.lv_item, null, true)

            holder.image = convertView.findViewById(R.id.imageView2) as ImageView
            holder.title = convertView!!.findViewById(R.id.title) as TextView
            holder.description = convertView.findViewById(R.id.description) as TextView



            convertView.tag = holder
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = convertView.tag as ViewHolder
        }

        holder.image!!.setImageResource(challengeModelArrayList[position].getImage())
        holder.title!!.text = challengeModelArrayList[position].getTitles()
        holder.description!!.text = challengeModelArrayList[position].getDescription()

        return convertView
    }

    private inner class ViewHolder {

        var title: TextView? = null
        var description: TextView? = null
        internal var image: ImageView? = null
    }

}