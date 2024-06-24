import mongoose, { Schema } from "mongoose";

const videoSchema = new Schema({
  title: {
    type: String,
  },
  link: {
    type: String,
  },
});

export const Video = mongoose.model("Video", videoSchema);
