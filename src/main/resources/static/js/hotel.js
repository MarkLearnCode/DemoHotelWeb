//=====================index=====================
const northPic = document.getElementById("northPic");
const middlePic = document.getElementById("middlePic");
const southPic = document.getElementById("southPic");
const eastPic = document.getElementById("eastPic");
const islandPic = document.getElementById("islandPic");

const picBox = document.getElementsByClassName("picBox");

northPic.onclick = () => {
  window.location.href = "./area.html";
  localStorage.setItem("areaName", "north");
  // history.pushState(null, null, "/area/north");
};
middlePic.onclick = () => {
  window.location.href = "./area.html";
  localStorage.setItem("areaName", "middle");
};
southPic.onclick = () => {
  window.location.href = "./area.html";
  localStorage.setItem("areaName", "south");
};
eastPic.onclick = () => {
  window.location.href = "./area.html";
  localStorage.setItem("areaName", "huadong");
};
islandPic.onclick = () => {
  window.location.href = "./area.html";
  localStorage.setItem("areaName", "island");
};



//=====================index=====================
//=====================area=====================
