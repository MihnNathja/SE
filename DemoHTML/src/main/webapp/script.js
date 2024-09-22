document.getElementById('view-detail-mode').addEventListener('change', function() {
    const detailsSection = document.getElementById('details-section');
    const selectedMode = this.value;
    
    if (selectedMode === 'none') {
        detailsSection.style.width = 'auto';
		fileListSection.style.width = '100%';
        detailsSection.textContent = 'None';
		
    } else if (selectedMode === 'preview') {
        detailsSection.style.width = '30%'; // Tăng chiều cao khi ở chế độ Preview
		fileListSection.style.width = '70%';
		detailsSection.textContent = 'Preview content';
    } else if (selectedMode === 'details') {
        detailsSection.style.width = '40%'; // Tăng chiều cao nhiều hơn ở chế độ Details
		fileListSection.style.width = '60%';
		detailsSection.textContent = 'Detailed content';
    }
});
